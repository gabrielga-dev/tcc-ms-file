package br.com.events.file.application.process.validation.file.validations.image;

import br.com.events.file.application.process.validation.file.validations.image.exception.ImageFileSizeExceededException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ImageFileSizeValidation implements FileValidation {

    @Value("${file.validation.image.size}")
    private Long fileSize;

    @Override
    public boolean matches(UploadFileRequest param) {
        return Objects.equals(FileType.IMAGE, param.getFileType());
    }

    @Override
    public void validate(UploadFileRequest toValidate) {
        if(toValidate.getFile().getSize() > fileSize){
            throw new ImageFileSizeExceededException();
        }
    }
}
