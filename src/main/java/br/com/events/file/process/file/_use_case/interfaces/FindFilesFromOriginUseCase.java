package br.com.events.file.process.file._use_case.interfaces;

import br.com.events.file.domain.io.inbound.file.findFiles.in.FindFilesRequest;
import br.com.events.file.domain.io.inbound.file.findFiles.out.FindFilesResult;

import java.util.List;

public interface FindFilesFromOriginUseCase {

    List<FindFilesResult> execute(FindFilesRequest request);
}
