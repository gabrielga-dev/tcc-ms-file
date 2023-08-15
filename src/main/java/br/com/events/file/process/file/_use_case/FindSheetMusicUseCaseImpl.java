package br.com.events.file.process.file._use_case;

import br.com.events.file.domain.exception.file.FileNotFoundException;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.repository.FileRepository;
import br.com.events.file.process.file._use_case.interfaces.FindFileUseCase;
import br.com.events.file.process.file._use_case.interfaces.FindSheetMusicUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindSheetMusicUseCaseImpl implements FindSheetMusicUseCase {

    private final FileRepository fileRepository;
    private final FindFileUseCase findFileUseCase;

    @Override
    public byte[] execute(String fileUuid) {

        var file = fileRepository.findByUuidAndType(fileUuid, FileType.SHEET_MUSIC)
                .orElseThrow(FileNotFoundException::new);

        return findFileUseCase.execute(file.getName());
    }
}
