package br.com.events.file.infrastructure.usecase.file;

import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.file.upload.out.UploadFileResult;
import br.com.events.file.infrastructure.usecase.UseCaseBase;

public interface UploadFileUseCase extends UseCaseBase<UploadFileRequest, UploadFileResult> {
}
