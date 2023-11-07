package br.com.events.file.business.exception.file;

public class SheetMusicFileSizeExceededException extends FileSizeExceededException {

    public SheetMusicFileSizeExceededException() {
        super("partitura", 5L);
    }
}
