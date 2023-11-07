package br.com.events.file.adapter.s3;

import org.springframework.web.multipart.MultipartFile;

public interface S3Adapter {

    byte[] getFile(String remoteFilePath);

    void uploadFile(String remoteFilePath, MultipartFile file);
}
