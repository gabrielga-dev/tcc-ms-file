package br.com.events.file.domain.exception.file;

import br.com.events.file.domain.exception.internalException.InternalException;

public class RetrieveFileException extends InternalException {

    public RetrieveFileException() {
        super(
                "Erro ao buscar arquivo!",
                "Ocorreu algo de inesperado ao buscar o arquivo desejado, tente novamente mais tarde!"
        );
    }
}
