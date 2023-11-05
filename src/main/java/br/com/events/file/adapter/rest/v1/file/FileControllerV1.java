package br.com.events.file.adapter.rest.v1.file;

import br.com.events.file.business.service.file.FileService;
import br.com.events.file.adapter.rest.v1.file.doc.FileControllerV1Doc;
import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.find.out.FindFilesResponse;
import br.com.events.file.domain.io.file.upload.out.UploadFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/file")
public class FileControllerV1 implements FileControllerV1Doc {

    private final FileService fileService;

    @Override
    @GetMapping(value = "/image/{uuid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("uuid") String uuid) {
        var result = fileService.getImage(uuid);

        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/origin")
    public ResponseEntity<List<FindFilesResponse>> getFiles(
            @RequestParam String origin, @RequestParam String originUuid
    ) {
        var result = fileService.getOriginFiles(origin, originUuid);
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping(value = "/sheet/{uuid}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getSheetMusic(@PathVariable("uuid") String uuid) {
        var result = fileService.getSheetMusic(uuid);

        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping(value = "/contract/{uuid}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getContract(@PathVariable("uuid") String uuid) {
        var result = fileService.getContract(uuid);

        return ResponseEntity.ok(result);
    }

    @Override
    @PostMapping
    public ResponseEntity<UploadFileResponse> uploadFile(
            @RequestParam String origin,
            @RequestParam String originUuid,
            @RequestParam FileType fileType,
            @RequestParam("file") MultipartFile file
    ) {
        var result = fileService.upload(origin, originUuid, fileType, file);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    @GetMapping(value = "/default/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getDefaultUserPicture() {
        var result = fileService.getDefaultUserImage();
        return ResponseEntity.ok(result);
    }
}
