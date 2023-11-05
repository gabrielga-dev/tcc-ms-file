package br.com.events.file.business.process.file.validation;

import br.com.events.file.business.process.BaseProcess;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;

public interface FileValidation extends BaseProcess<UploadFileRequest, Void> {

    default void validate(UploadFileRequest fileRequest){
        this.process(fileRequest);
    }
}
