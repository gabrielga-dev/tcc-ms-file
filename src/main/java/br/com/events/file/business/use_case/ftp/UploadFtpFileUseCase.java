package br.com.events.file.business.use_case.ftp;

import br.com.events.file.adapter.ftp.FtpFileAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UploadFtpFileUseCase {

    private final FtpFileAdapter ftpFileAdapter;

    public void execute(String fileName, MultipartFile multipartFile){
        ftpFileAdapter.uploadFile(fileName, multipartFile);
    }
}
