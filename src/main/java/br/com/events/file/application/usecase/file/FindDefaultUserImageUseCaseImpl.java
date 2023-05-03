package br.com.events.file.application.usecase.file;

import br.com.events.file.application.usecase.file.exception.FileNotFoundException;
import br.com.events.file.domain.repository.FileRepository;
import br.com.events.file.infrastructure.usecase.file.FindDefaultUserImageUseCase;
import br.com.events.file.infrastructure.usecase.file.FindFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindDefaultUserImageUseCaseImpl implements FindDefaultUserImageUseCase {

    private final FileRepository fileRepository;
    private final FindFileUseCase findFileUseCase;

    @Override
    public byte[] execute(Void param) {
        var file = fileRepository.findById("DEFAULT_USER_PICTURE").orElseThrow(FileNotFoundException::new);
        return findFileUseCase.execute(file.getName());
    }
}
