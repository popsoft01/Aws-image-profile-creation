package com.example.awsimageupload.profile;

import com.example.awsimageupload.Bucket.BucketName;
import com.example.awsimageupload.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }
    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        isFileExit(file);
        isFileAnImage(file);
        getAnImage(userProfileId);

        Map<String, String> metadeta = new HashMap<>();
        metadeta.put("Content-Type", file.getContentType());
        metadeta.put("Content-length",String.valueOf( file.getSize()));
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileDataAccessService.getUserProfiles());
        String fileName = String.format("%s-%s",file.getOriginalFilename(), UUID.randomUUID());
        try {
            fileStore.save(path, fileName, Optional.of(metadeta), file.getInputStream());
        }catch (IOException e){
            throw new IllegalStateException("File upload fail ");
        }
    }

    private void getAnImage(UUID userProfileId) {
        userProfileDataAccessService.getUserProfiles()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException(String.format( "User not available in database", userProfileId)));
    }

    private void isFileAnImage(MultipartFile file) {
        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an Image");
        }
    }

    private void isFileExit(MultipartFile file) {
        if (file.isEmpty() ){
            throw new IllegalStateException("Image not found");
        }
    }

}
