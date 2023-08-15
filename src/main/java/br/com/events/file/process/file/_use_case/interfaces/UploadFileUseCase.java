package br.com.events.file.process.file._use_case.interfaces;

import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.inbound.file.upload.out.UploadFileResult;

public interface UploadFileUseCase {

    UploadFileResult execute(UploadFileRequest request);
}
