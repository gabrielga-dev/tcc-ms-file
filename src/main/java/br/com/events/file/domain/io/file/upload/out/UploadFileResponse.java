package br.com.events.file.domain.io.file.upload.out;

import br.com.events.file.domain.entity.File;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UploadFileResponse {

    private String uuid;
    private String fileName;

    public UploadFileResponse(File file) {
        this.uuid = file.getUuid();
        this.fileName = file.getName();
    }
}
