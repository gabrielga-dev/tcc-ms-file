package br.com.events.file.infrastructure.usecase.file;

import br.com.events.file.domain.io.file.findFiles.in.FindFilesRequest;
import br.com.events.file.domain.io.file.findFiles.out.FindFilesResult;
import br.com.events.file.infrastructure.usecase.UseCaseBase;

import java.util.List;

public interface FindFilesFromOriginUseCase extends UseCaseBase<FindFilesRequest, List<FindFilesResult>> {
}
