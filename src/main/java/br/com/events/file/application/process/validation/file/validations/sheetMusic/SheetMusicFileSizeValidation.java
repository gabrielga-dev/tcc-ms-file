package br.com.events.file.application.process.validation.file.validations.sheetMusic;

import br.com.events.file.application.process.validation.file.validations.sheetMusic.exception.SheetMusicFileSizeExceededException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SheetMusicFileSizeValidation implements FileValidation {

    @Value("${file.validation.sheet.size}")
    private Long fileSize;

    @Override
    public boolean matches(UploadFileRequest param) {
        return Objects.equals(FileType.SHEET_MUSIC, param.getFileType());
    }

    @Override
    public void validate(UploadFileRequest toValidate) {
        if(toValidate.getFile().getSize() > fileSize){
            throw new SheetMusicFileSizeExceededException();
        }
    }
}
