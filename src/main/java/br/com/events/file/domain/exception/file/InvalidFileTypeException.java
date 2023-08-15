package br.com.events.file.domain.exception.file;

import br.com.events.file.domain.exception.badRequest.UnprocessableEntityException;

public class InvalidFileTypeException extends UnprocessableEntityException {

    public InvalidFileTypeException() {
        super(
                "Tipo de arquivo invalido!",
                "O tipo do arquivo informado é diferente do esperado!");
    }
}
