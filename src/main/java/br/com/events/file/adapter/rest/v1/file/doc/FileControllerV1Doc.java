package br.com.events.file.adapter.rest.v1.file.doc;

import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.find.out.FindFilesResponse;
import br.com.events.file.domain.io.file.upload.out.UploadFileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "File Controller")
public interface FileControllerV1Doc {

    @ApiOperation(value = "Returns the image that have the following uuid")
    ResponseEntity<byte[]> getImage(String uuid);

    @ApiOperation(value = "Returns files from a specific origin")
    ResponseEntity<List<FindFilesResponse>> getFiles(String origin, String originUuid);

    @ApiOperation(value = "Returns the sheet music that have the following uuid")
    ResponseEntity<byte[]> getSheetMusic(String uuid);

    @ApiOperation(value = "Returns the contract that have the following uuid")
    ResponseEntity<byte[]> getContract(String uuid);

    @ApiOperation(value = "Returns the image that have the following uuid")
    ResponseEntity<UploadFileResponse> uploadFile(
            String origin, String originUuid, FileType fileType, MultipartFile file
    );

    @ApiOperation(value = "Returns the default person image")
    ResponseEntity<byte[]> getDefaultUserPicture();
}
