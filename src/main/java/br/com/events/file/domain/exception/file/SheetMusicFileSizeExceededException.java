package br.com.events.file.domain.exception.file;

public class SheetMusicFileSizeExceededException extends FileSizeExceededException {

    public SheetMusicFileSizeExceededException() {
        super("partitura", 5L);
    }
}
