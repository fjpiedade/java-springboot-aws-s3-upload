package com.raiztech.imageawsupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIARNT7NJD6LGTERK7R",
                "Omuvrqz8gpQI0xtvjWK+R896lV8F1fotgUulOal2"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-west-1") //missing before
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
