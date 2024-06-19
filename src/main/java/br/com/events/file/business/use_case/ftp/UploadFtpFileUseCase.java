package br.com.events.file.business.use_case.ftp;

import br.com.events.file.adapter.file.FileAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UploadFtpFileUseCase {

    private final FileAdapter ftpFileAdapter;

    public void execute(String fileName, MultipartFile multipartFile) {
        ftpFileAdapter.uploadFile(fileName, multipartFile);
    }
}
