package br.com.events.file.process.file._use_case;

import br.com.events.file.domain.io.inbound.file.findFiles.FindFilesMapper;
import br.com.events.file.domain.io.inbound.file.findFiles.in.FindFilesRequest;
import br.com.events.file.domain.io.inbound.file.findFiles.out.FindFilesResult;
import br.com.events.file.domain.repository.FileRepository;
import br.com.events.file.process.file._use_case.interfaces.FindFilesFromOriginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindFilesFromOriginUseCaseImpl implements FindFilesFromOriginUseCase {

    private final FileRepository fileRepository;

    @Override
    public List<FindFilesResult> execute(FindFilesRequest param) {
        var files = fileRepository.findByOriginAndOriginUuid(param.getOrigin(), param.getOriginUuid());

        return FindFilesMapper.from(files);
    }
}
