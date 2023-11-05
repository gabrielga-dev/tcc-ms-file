package br.com.events.file.business.service.file;

import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.find.out.FindFilesResponse;
import br.com.events.file.domain.io.file.upload.out.UploadFileResponse;
import br.com.events.file.business.exception.file.FileNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FileService {

    Optional<File> findFile(String fileUuid, FileType fileType);
    byte[] getFtpFile(String fileName);

    default byte[] getDefaultUserImage(){
        var file = this.findFile("DEFAULT_USER_PICTURE", FileType.IMAGE)
                .orElseThrow(FileNotFoundException::new);

        return this.getFtpFile(file.getName());
    }

    default byte[] getImage(String imageUuid){
        var file = this.findFile(imageUuid, FileType.IMAGE)
                .orElseThrow(FileNotFoundException::new);

        return this.getFtpFile(file.getName());
    }

    default byte[] getSheetMusic(String sheetUuid){
        var file = this.findFile(sheetUuid, FileType.SHEET_MUSIC)
                .orElseThrow(FileNotFoundException::new);

        return this.getFtpFile(file.getName());
    }

    default byte[] getContract(String contractUuid){
        var file = this.findFile(contractUuid, FileType.CONTRACT)
                .orElseThrow(FileNotFoundException::new);

        return this.getFtpFile(file.getName());
    }

    List<FindFilesResponse> getOriginFiles(String origin, String originUuid);

    UploadFileResponse upload(String origin, String originUuid, FileType fileType, MultipartFile file);
}
