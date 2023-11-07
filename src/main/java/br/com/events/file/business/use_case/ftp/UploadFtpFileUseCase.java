package br.com.events.file.business.use_case.ftp;

import br.com.events.file.adapter.s3.S3Adapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UploadFtpFileUseCase {

    private final S3Adapter ftpFileAdapter;

    public void execute(String fileName, MultipartFile multipartFile) {
        ftpFileAdapter.uploadFile(fileName, multipartFile);
    }
}
