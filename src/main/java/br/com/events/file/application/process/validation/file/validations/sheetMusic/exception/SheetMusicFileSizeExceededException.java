package br.com.events.file.application.process.validation.file.validations.sheetMusic.exception;

import br.com.events.file.application.process.validation.file.exeption.FileSizeExceededException;

public class SheetMusicFileSizeExceededException extends FileSizeExceededException {

    public SheetMusicFileSizeExceededException() {
        super("partitura", 5L);
    }
}
