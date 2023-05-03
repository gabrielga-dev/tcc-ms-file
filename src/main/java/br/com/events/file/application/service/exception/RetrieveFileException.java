package br.com.events.file.application.service.exception;

import br.com.events.file.infrastructure.exception.internalException.InternalException;

public class RetrieveFileException extends InternalException {

    public RetrieveFileException() {
        super(
                "Erro ao buscar arquivo!",
                "Ocorreu algo de inesperado ao buscar o arquivo desejado, tente novamente mais tarde!"
        );
    }
}
