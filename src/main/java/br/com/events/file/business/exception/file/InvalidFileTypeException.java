package br.com.events.file.business.exception.file;

import br.com.events.file.adapter.rest.exception.badRequest.UnprocessableEntityException;

public class InvalidFileTypeException extends UnprocessableEntityException {

    public InvalidFileTypeException() {
        super(
                "Tipo de arquivo invalido!",
                "O tipo do arquivo informado é diferente do esperado!");
    }
}
