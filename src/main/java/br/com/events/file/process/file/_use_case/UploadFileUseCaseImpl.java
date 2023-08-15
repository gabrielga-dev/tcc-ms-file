package br.com.events.file.process.file._use_case;

import br.com.events.file.process.file.service.FtpService;
import br.com.events.file.domain.io.inbound.file.upload.UploadFileMapper;
import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.inbound.file.upload.out.UploadFileResult;
import br.com.events.file.domain.repository.FileRepository;
import br.com.events.file.process.file.validation.FileValidationCaller;
import br.com.events.file.process.file._use_case.interfaces.UploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UploadFileUseCaseImpl implements UploadFileUseCase {

    private final FileRepository fileRepository;
    private final FileValidationCaller fileValidationCaller;
    private final FtpService ftpService;

    @Override
    public UploadFileResult execute(UploadFileRequest param) {
        fileValidationCaller.callProcesses(param);

        var toSave = UploadFileMapper.from(param);
        toSave = fileRepository.save(toSave);

        ftpService.uploadFile(toSave.getName(), param.getFile());

        return UploadFileMapper.from(toSave);
    }
}
