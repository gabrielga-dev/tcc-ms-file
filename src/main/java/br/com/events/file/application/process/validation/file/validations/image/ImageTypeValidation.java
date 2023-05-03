package br.com.events.file.application.process.validation.file.validations.image;

import br.com.events.file.application.process.validation.file.exeption.InvalidFileTypeException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ImageTypeValidation implements FileValidation {

    @Override
    public boolean matches(UploadFileRequest param) {
        return Objects.equals(FileType.IMAGE, param.getFileType());
    }

    @Override
    public void validate(UploadFileRequest toValidate) {
        String contentType = toValidate.getFile().getContentType();
        if (Objects.isNull(contentType) || !contentType.startsWith("image/")) {
            throw new InvalidFileTypeException();
        }
    }
}
