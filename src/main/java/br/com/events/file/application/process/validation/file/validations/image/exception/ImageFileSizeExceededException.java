package br.com.events.file.application.process.validation.file.validations.image.exception;

import br.com.events.file.application.process.validation.file.exeption.FileSizeExceededException;

public class ImageFileSizeExceededException extends FileSizeExceededException {

    public ImageFileSizeExceededException() {
        super("imagem", 2L);
    }
}
