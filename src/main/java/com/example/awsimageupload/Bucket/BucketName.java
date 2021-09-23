package com.example.awsimageupload.Bucket;

public enum BucketName {
    PROFILE_IMAGE("popsoft-image-upload123");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
