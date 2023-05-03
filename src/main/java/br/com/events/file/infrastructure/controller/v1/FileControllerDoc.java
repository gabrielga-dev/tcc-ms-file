package br.com.events.file.infrastructure.controller.v1;

import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.out.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "File Controller")
public interface FileControllerDoc {

    @ApiOperation(value = "Returns the image that have the following uuid")
    ResponseEntity<byte[]> getImage(String uuid);

    @ApiOperation(value = "Returns the sheet music that have the following uuid")
    ResponseEntity<byte[]> getSheetMusic(String uuid);

    @ApiOperation(value = "Returns the image that have the following uuid")
    ResponseEntity<UploadFileResult> uploadFile(
            String origin, String originUuid, FileType fileType, MultipartFile file
    );
}
