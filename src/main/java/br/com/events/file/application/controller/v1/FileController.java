package br.com.events.file.application.controller.v1;

import br.com.events.file.domain.entity.FileType;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.file.upload.out.UploadFileResult;
import br.com.events.file.infrastructure.controller.v1.FileControllerDoc;
import br.com.events.file.infrastructure.usecase.file.FindImageUseCase;
import br.com.events.file.infrastructure.usecase.file.FindSheetMusicUseCase;
import br.com.events.file.infrastructure.usecase.file.UploadFileUseCase;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/file")
public class FileController implements FileControllerDoc {

    private final FindImageUseCase findImageUseCase;
    private final FindSheetMusicUseCase findSheetMusicUseCase;
    private final UploadFileUseCase uploadFileUseCase;

    @Override
    @GetMapping(value = "/image/{uuid}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("uuid") String uuid) {
        var result = findImageUseCase.execute(uuid);

        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping(value = "/sheet/{uuid}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getSheetMusic(@PathVariable("uuid") String uuid) {
        var result = findSheetMusicUseCase.execute(uuid);

        return ResponseEntity.ok(result);
    }

    @Override
    @PostMapping
    public ResponseEntity<UploadFileResult> uploadFile(
            @RequestParam String origin,
            @RequestParam String originUuid,
            @RequestParam FileType fileType,
            @RequestParam("file") MultipartFile file
    ) {
        var request = UploadFileRequest
                .builder()
                .origin(origin)
                .originUuid(originUuid)
                .fileType(fileType)
                .file(file)
                .build();
        var result = uploadFileUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
