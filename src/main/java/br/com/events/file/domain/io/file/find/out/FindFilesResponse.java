package br.com.events.file.domain.io.file.find.out;

import br.com.events.file.domain.entity.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindFilesResponse {

    private String fileUuid;

    public FindFilesResponse(File file) {
        this.fileUuid = file.getUuid();
    }
}
