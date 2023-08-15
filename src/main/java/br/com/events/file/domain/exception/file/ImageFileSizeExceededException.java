package br.com.events.file.domain.exception.file;

public class ImageFileSizeExceededException extends FileSizeExceededException {

    public ImageFileSizeExceededException() {
        super("imagem", 2L);
    }
}
