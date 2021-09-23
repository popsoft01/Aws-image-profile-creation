package com.example.awsimageupload;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwsImageUploadApplication {
//	@Bean
//	public AmazonS3 s3(){
//		AWSCredentials awsCredentials = new BasicAWSCredentials(
//				"AKIAVGA7IWQ2DWNJBUEN",
//				"fufYMG9ilxugV/gjqbLftscOjC4V8r0hq+cpW5C5"
//		);
//		return AmazonS3ClientBuilder
//				.standard()
//				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//				.withRegion("ap-south-1")
//				.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(AwsImageUploadApplication.class, args);
	}

}
