package br.com.events.file.business.exception.file;

public class ImageFileSizeExceededException extends FileSizeExceededException {

    public ImageFileSizeExceededException() {
        super("imagem", 2L);
    }
}
