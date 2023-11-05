package br.com.events.file.business.process.file.validation.caller;

import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.business.process.file.validation.FileValidation;
import br.com.events.file.business.process.file.validation.FileValidationCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FileValidationCallerImpl implements FileValidationCaller {

    private final List<FileValidation> fileValidations;

    @Override
    public void callProcesses(UploadFileRequest param) {
        fileValidations.stream()
                .filter(f -> f.isAccepted(param))
                .forEach(f -> f.validate(param));
    }
}
