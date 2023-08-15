package br.com.events.file.process.file.validation.validations.contract;

import br.com.events.file.domain.exception.file.SheetMusicFileSizeExceededException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.process.file.validation.FileValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContractFileSizeValidation implements FileValidation {

    @Value("${file.validation.contract.size}")
    private Long fileSize;

    @Override
    public boolean isAccepted(UploadFileRequest param) {
        return Objects.equals(FileType.CONTRACT, param.getFileType());
    }

    @Override
    public Void process(UploadFileRequest toValidate) {
        if(toValidate.getFile().getSize() > fileSize){
            throw new SheetMusicFileSizeExceededException();
        }
        return null;
    }
}
