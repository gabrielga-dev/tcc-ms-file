package br.com.events.file.domain.io.file.upload.in;

import br.com.events.file.domain.entity.FileType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UploadFileRequest {

    private String origin;
    private String originUuid;
    private FileType fileType;
    private MultipartFile file;
}
