package br.com.events.file.application.process.validation.file;

import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.infrastructure.process.validation.file.FileValidation;
import br.com.events.file.infrastructure.process.validation.file.FileValidationCaller;
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
                .filter(f -> f.matches(param))
                .forEach(f -> f.validate(param));
    }
}
