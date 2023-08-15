package br.com.events.file.domain.io.inbound.file.findFiles;

import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.io.inbound.file.findFiles.in.FindFilesRequest;
import br.com.events.file.domain.io.inbound.file.findFiles.out.FindFilesResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindFilesMapper {

    public static List<FindFilesResult> from(List<File> files){
        return files.stream().map(FindFilesMapper::from).collect(Collectors.toList());
    }

    public static FindFilesResult from(File file){
        return new FindFilesResult(file.getUuid());
    }

    public static FindFilesRequest from(String origin, String originUuid) {
        return new FindFilesRequest(origin, originUuid);
    }
}
