package br.com.events.file.business.process.file.validation.validations.contract;

import br.com.events.file.business.exception.file.InvalidFileTypeException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.business.process.file.validation.FileValidation;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContractFileTypeValidation implements FileValidation {

    @Override
    public boolean isAccepted(UploadFileRequest param) {
        return Objects.equals(FileType.CONTRACT, param.getFileType());
    }

    @Override
    public Void process(UploadFileRequest toValidate) {
        String contentType = toValidate.getFile().getContentType();
        if (Objects.isNull(contentType) || !contentType.equals("application/pdf")) {
            throw new InvalidFileTypeException();
        }
        return null;
    }
}
