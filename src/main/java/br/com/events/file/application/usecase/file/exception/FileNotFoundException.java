package br.com.events.file.application.usecase.file.exception;

import br.com.events.file.infrastructure.exception.badRequest.NotFoundException;

public class FileNotFoundException extends NotFoundException {

    public FileNotFoundException() {
        super(
                "Não foi possível encontrar o arquivo!",
                "Não foi encontrado nenhum arquivo com as credenciais informadas!"
        );
    }
}
