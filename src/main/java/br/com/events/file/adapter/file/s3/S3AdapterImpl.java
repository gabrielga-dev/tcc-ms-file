package br.com.events.file.adapter.file.s3;

import br.com.events.file.adapter.file.FileAdapter;
import br.com.events.file.business.exception.file.RetrieveFileException;
import br.com.events.file.business.exception.file.UploadFileException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "file.technology", havingValue = "s3")
public class S3AdapterImpl implements FileAdapter {

    @Value("${aws.s3.name}")
    private String bucketName;

    private final AmazonS3 amazonS3Client;

    @Override
    public byte[] getFile(String remoteFilePath) {
        try {
            log.info("[START] Searching for {}", remoteFilePath);
            var s3object = amazonS3Client.getObject(bucketName, remoteFilePath);
            log.info("[...] File {} found!", remoteFilePath);
            var bytes = s3object.getObjectContent().readAllBytes();
            log.info("[END] Success for retrieving the file {}", remoteFilePath);
            return bytes;
        } catch (IOException e) {
            log.info(
                    "[END] Error when retrieving the file {}. {}; {}",
                    remoteFilePath, e.getMessage(), e.getLocalizedMessage()
            );
            throw new RetrieveFileException();
        }
    }

    @Override
    public void uploadFile(String remoteFilePath, MultipartFile file) {
        try {
            log.info("[START] Uploading {}", remoteFilePath);

            var metaData = new ObjectMetadata();
            metaData.setContentType(file.getContentType());
            metaData.setContentLength(file.getSize());

            amazonS3Client.putObject(bucketName, remoteFilePath, file.getInputStream(), metaData);

            log.info("[END] Success for uploading the file {}", remoteFilePath);

        } catch (Exception e) {
            log.info(
                    "[END] Error when uploading the file {}. {}; {}",
                    remoteFilePath, e.getMessage(), e.getLocalizedMessage()
            );
            throw new UploadFileException();
        }
    }
}
