package br.com.events.file.adapter.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileAdapter {

    byte[] getFile(String remoteFilePath);

    void uploadFile(String remoteFilePath, MultipartFile file);
}
