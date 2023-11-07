package br.com.events.file.business.use_case.file;

import br.com.events.file.adapter.repository.FileRepository;
import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.entity.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindFileUseCase {

    private final FileRepository fileRepository;

    public Optional<File> byUuid(String fileUuid) {
        return fileRepository.findById(fileUuid);
    }

    public Optional<File> byUuidAndType(String fileUuid, FileType fileType) {
        return fileRepository.findByUuidAndType(fileUuid, fileType);
    }

    public List<File> byOriginAndOriginUuid(String origin, String originUuid) {
        return fileRepository.findByOriginAndOriginUuid(origin, originUuid);
    }
}
