package br.com.events.file.application.process.validation.file.validations.sheetMusic;

import br.com.events.file.application.process.validation.file.exeption.InvalidFileTypeException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SheetMusicFileTypeValidation implements FileValidation {

    @Override
    public boolean matches(UploadFileRequest param) {
        return Objects.equals(FileType.SHEET_MUSIC, param.getFileType());
    }

    @Override
    public void validate(UploadFileRequest toValidate) {
        String contentType = toValidate.getFile().getContentType();
        if (Objects.isNull(contentType) || !contentType.equals("application/pdf")) {
            throw new InvalidFileTypeException();
        }
    }
}
