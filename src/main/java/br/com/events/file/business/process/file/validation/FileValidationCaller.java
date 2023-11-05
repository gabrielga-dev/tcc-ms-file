package br.com.events.file.business.process.file.validation;

import br.com.events.file.business.process.BaseProcessCaller;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;

public interface FileValidationCaller extends BaseProcessCaller<UploadFileRequest, Void> {

    default void validate(UploadFileRequest fileRequest){
        this.callProcesses(fileRequest);
    }
}
