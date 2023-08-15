package br.com.events.file.domain.io.inbound.file.upload;

import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.io.inbound.file.upload.in.UploadFileRequest;
import br.com.events.file.domain.io.inbound.file.upload.out.UploadFileResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UploadFileMapper {

    public static File from(UploadFileRequest origin) {
        var now = LocalDateTime.now();

        var toReturn = new File();
        toReturn.setName(generateFileName(origin, now));
        toReturn.setType(origin.getFileType());
        toReturn.setOrigin(origin.getOrigin());
        toReturn.setOriginUuid(origin.getOriginUuid());
        toReturn.setCreationDate(now);

        return toReturn;
    }

    private static String generateFileName(UploadFileRequest origin, LocalDateTime now) {
        return origin.getFileType().name() +
                "_" +
                origin.getOrigin() +
                "_" +
                origin.getOriginUuid() +
                "_" +
                now.getYear() +
                now.getMonthValue() +
                now.getDayOfMonth() +
                now.getHour() +
                now.getMinute() +
                "." +
                origin.getFileType().getExtension(origin.getFile());
    }

    public static UploadFileResult from(File file) {
        return new UploadFileResult(file.getUuid(), file.getName());
    }
}
