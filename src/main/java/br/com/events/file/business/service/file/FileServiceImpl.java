package br.com.events.file.business.service.file;

import br.com.events.file.business.process.file.validation.FileValidationCaller;
import br.com.events.file.business.use_case.file.BuildFileUseCase;
import br.com.events.file.business.use_case.file.FindFileUseCase;
import br.com.events.file.business.use_case.file.SaveFileUseCase;
import br.com.events.file.business.use_case.ftp.GetFileUseCase;
import br.com.events.file.business.use_case.ftp.UploadFtpFileUseCase;
import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.find.out.FindFilesResponse;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.file.upload.out.UploadFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileValidationCaller fileValidationCaller;

    private final GetFileUseCase getFtpFileUseCase;
    private final UploadFtpFileUseCase uploadFtpFileUseCase;

    private final FindFileUseCase findFileUseCase;
    private final BuildFileUseCase buildFileUseCase;
    private final SaveFileUseCase saveFileUseCase;

    @Override
    public Optional<File> findFile(String fileUuid, FileType fileType) {
        return findFileUseCase.byUuidAndType(fileUuid, fileType);
    }

    @Override
    public byte[] getFtpFile(String fileName) {
        return getFtpFileUseCase.execute(fileName);
    }

    @Override
    public List<FindFilesResponse> getOriginFiles(String origin, String originUuid) {
        return findFileUseCase.byOriginAndOriginUuid(origin, originUuid)
                .stream()
                .map(FindFilesResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public UploadFileResponse upload(String origin, String originUuid, FileType fileType, MultipartFile file) {
        var uploadRequest = new UploadFileRequest(origin, originUuid, fileType, file);
        fileValidationCaller.validate(uploadRequest);

        var newFile = buildFileUseCase.execute(uploadRequest);
        var savedFile = saveFileUseCase.execute(newFile);

        uploadFtpFileUseCase.execute(savedFile.getName(), file);

        return new UploadFileResponse(savedFile);
    }
}
