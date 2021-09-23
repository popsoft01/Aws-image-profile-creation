package com.example.awsimageupload.dataStore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Configuration
@Repository
public class FakeUserProfileDataStore {
    private static  final List<UserProfile> USER_PROFILE = new ArrayList<>();

    static {
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(),
                "Damilare",null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(),
                "Igbekele",null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(),
                "Omolara",null));

    }
    @Bean
    public  List<UserProfile> getUserProfile(){
        return USER_PROFILE;
    }
}
