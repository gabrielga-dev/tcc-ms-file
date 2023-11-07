package br.com.events.file.business.use_case.ftp;

import br.com.events.file.adapter.s3.S3AdapterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetFtpFileUseCase {

    private final S3AdapterImpl ftpFileAdapter;

    public byte[] execute(String fileName) {
        return ftpFileAdapter.getFile(fileName);
    }
}
