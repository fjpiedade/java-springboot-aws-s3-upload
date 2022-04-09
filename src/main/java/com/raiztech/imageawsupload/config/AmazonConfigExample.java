package com.raiztech.imageawsupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfigExample {
    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "your_accessKey",
                "your_secretKey"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("your-region") //missing before
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
