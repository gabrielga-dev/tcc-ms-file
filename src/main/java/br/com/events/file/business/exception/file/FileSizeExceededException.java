package br.com.events.file.business.exception.file;

import br.com.events.file.adapter.rest.exception.badRequest.UnprocessableEntityException;

public class FileSizeExceededException extends UnprocessableEntityException {

    public FileSizeExceededException(String fileType, Long maxFileSize) {
        super(
                "Tamanho de arquivo excedido!",
                "O tamanho máximo permitido para arquivos de " + fileType + " é de " + maxFileSize + "Mb!");
    }
}
