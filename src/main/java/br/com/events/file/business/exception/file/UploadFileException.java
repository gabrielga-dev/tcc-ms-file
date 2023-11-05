package br.com.events.file.business.exception.file;

import br.com.events.file.adapter.rest.exception.internalException.InternalException;

public class UploadFileException extends InternalException {

    public UploadFileException() {
        super(
                "Erro ao fazer upload do arquivo!",
                "Ocorreu algo de inesperado ao fazer o upload do arquivo desejado, tente novamente mais tarde!"
        );
    }
}
