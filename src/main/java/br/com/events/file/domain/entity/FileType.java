package br.com.events.file.domain.entity;

import br.com.events.file.domain.entity.strategy.FileTypeStrategy;
import org.springframework.web.multipart.MultipartFile;

public enum FileType implements FileTypeStrategy {
    IMAGE {
        @Override
        public String getExtension(MultipartFile multipartFile) {
            return "jpeg";
        }
    },
    CONTRACT {
        @Override
        public String getExtension(MultipartFile multipartFile) {
            return "pdf";
        }
    },
    SHEET_MUSIC {
        @Override
        public String getExtension(MultipartFile multipartFile) {
            var fileName = multipartFile.getOriginalFilename();
            int extensionIndex = fileName.lastIndexOf('.');
            return fileName.substring(extensionIndex + 1);
        }
    }
}
