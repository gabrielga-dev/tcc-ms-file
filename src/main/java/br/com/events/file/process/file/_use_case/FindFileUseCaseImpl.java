package br.com.events.file.process.file._use_case;

import br.com.events.file.process.file.service.FtpService;
import br.com.events.file.process.file._use_case.interfaces.FindFileUseCase;
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
