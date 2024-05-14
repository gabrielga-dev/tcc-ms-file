package br.com.events.file.business.use_case.ftp.impl;

import br.com.events.file.adapter.file.FileAdapter;
import br.com.events.file.business.use_case.ftp.GetFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetFileUseCaseImpl implements GetFileUseCase {

    private final FileAdapter fileAdapter;

    public byte[] execute(String fileName) {
        return fileAdapter.getFile(fileName);
    }
}
