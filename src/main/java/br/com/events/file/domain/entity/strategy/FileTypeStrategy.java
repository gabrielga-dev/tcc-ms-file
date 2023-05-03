package br.com.events.file.domain.entity.strategy;

import org.springframework.web.multipart.MultipartFile;

public interface FileTypeStrategy {

    String getExtension(MultipartFile multipartFile);
}
