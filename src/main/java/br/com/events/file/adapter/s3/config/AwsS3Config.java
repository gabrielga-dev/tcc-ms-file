package br.com.events.file.adapter.s3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3Config {

    @Value("${aws.s3.access-key}")
    private String s3UserAccessKey;
    @Value("${aws.s3.secret-key}")
    private String s3UserSecretKey;
    @Value("${aws.s3.region}")
    private String s3Region;

    public AWSCredentials credentials() {
        return new BasicAWSCredentials(s3UserAccessKey, s3UserSecretKey);
    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(s3Region)
                .build();
    }
}
