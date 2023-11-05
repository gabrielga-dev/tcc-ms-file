package br.com.events.file.business.use_case.file;

import br.com.events.file.adapter.repository.FileRepository;
import br.com.events.file.domain.entity.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveFileUseCase {

    private final FileRepository fileRepository;

    public File execute(File file){
        return fileRepository.save(file);
    }
}
