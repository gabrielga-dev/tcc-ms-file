package br.com.events.file.process.file._use_case;

import br.com.events.file.domain.exception.file.FileNotFoundException;
import br.com.events.file.domain.repository.FileRepository;
import br.com.events.file.process.file._use_case.interfaces.FindDefaultUserImageUseCase;
import br.com.events.file.process.file._use_case.interfaces.FindFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindDefaultUserImageUseCaseImpl implements FindDefaultUserImageUseCase {

    private final FileRepository fileRepository;
    private final FindFileUseCase findFileUseCase;

    @Override
    public byte[] execute() {
        var file = fileRepository.findById("DEFAULT_USER_PICTURE").orElseThrow(FileNotFoundException::new);
        return findFileUseCase.execute(file.getName());
    }
}
