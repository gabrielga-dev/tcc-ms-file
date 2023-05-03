package br.com.events.file.domain.io.file.findFiles.in;

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
public class FindFilesRequest {

    private String origin;
    private String originUuid;
}
