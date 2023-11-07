package br.com.events.file.domain.entity;

import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents the file's database table
 *
 * @author Gabriel Guimarães de Almeida
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "file")
public class File {

    @Id
    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FileType type;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "origin_uuid", nullable = false)
    private String originUuid;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    public File(UploadFileRequest request) {
        var now = LocalDateTime.now();

        this.name = generateFileName(request, now);
        this.type = request.getFileType();
        this.origin = request.getOrigin();
        this.originUuid = request.getOriginUuid();
        this.creationDate = now;
    }

    private String generateFileName(UploadFileRequest origin, LocalDateTime now) {
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
}
