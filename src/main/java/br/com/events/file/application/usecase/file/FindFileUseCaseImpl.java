package br.com.events.file.application.usecase.file;

import br.com.events.file.application.service.FtpService;
import br.com.events.file.infrastructure.usecase.file.FindFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindFileUseCaseImpl implements FindFileUseCase {

    private final FtpService ftpService;

    @Override
    public byte[] execute(String fileName) {
        return ftpService.getFile(fileName);
    }
}
