package br.com.events.file.application.process.validation.file.exeption;

import br.com.events.file.infrastructure.exception.badRequest.UnprocessableEntityException;

public class InvalidFileTypeException extends UnprocessableEntityException {

    public InvalidFileTypeException() {
        super(
                "Tipo de arquivo invalido!",
                "O tipo do arquivo informado é diferente do esperado!");
    }
}
