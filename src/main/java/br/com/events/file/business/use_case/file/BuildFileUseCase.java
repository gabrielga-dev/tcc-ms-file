package br.com.events.file.business.use_case.file;

import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.io.file.upload.in.UploadFileRequest;
import org.springframework.stereotype.Component;

@Component
public class BuildFileUseCase {

    public File execute(UploadFileRequest request){
        return new File(request);
    }
}
