package br.com.events.file.business.use_case.ftp;

import br.com.events.file.adapter.ftp.FtpFileAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetFtpFileUseCase {

    private final FtpFileAdapter ftpFileAdapter;

    public byte[] execute(String fileName){
        return ftpFileAdapter.getFile(fileName);
    }
}
