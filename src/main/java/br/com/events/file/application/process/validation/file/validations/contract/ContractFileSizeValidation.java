package br.com.events.file.application.process.validation.file.validations.contract;

import br.com.events.file.application.process.validation.file.validations.contract.exception.SheetMusicFileSizeExceededException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContractFileSizeValidation implements FileValidation {

    @Value("${file.validation.contract.size}")
    private Long fileSize;

    @Override
    public boolean matches(UploadFileRequest param) {
        return Objects.equals(FileType.CONTRACT, param.getFileType());
    }

    @Override
    public void validate(UploadFileRequest toValidate) {
        if(toValidate.getFile().getSize() > fileSize){
            throw new SheetMusicFileSizeExceededException();
        }
    }
}
