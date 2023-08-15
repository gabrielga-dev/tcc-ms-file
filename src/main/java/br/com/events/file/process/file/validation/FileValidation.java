package br.com.events.file.process.file.validation;

import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.process.BaseProcess;

public interface FileValidation extends BaseProcess<UploadFileRequest, Void> {

    default void validate(UploadFileRequest fileRequest){
        this.process(fileRequest);
    }
}
