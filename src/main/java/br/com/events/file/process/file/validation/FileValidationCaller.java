package br.com.events.file.process.file.validation;

import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.process.BaseProcessCaller;

public interface FileValidationCaller extends BaseProcessCaller<UploadFileRequest, Void> {

    default void validate(UploadFileRequest fileRequest){
        this.callProcesses(fileRequest);
    }
}
