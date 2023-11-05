package br.com.events.file.business.exception.file;

import br.com.events.file.adapter.rest.exception.badRequest.NotFoundException;

public class FileNotFoundException extends NotFoundException {

    public FileNotFoundException() {
        super(
                "Não foi possível encontrar o arquivo!",
                "Não foi encontrado nenhum arquivo com as credenciais informadas!"
        );
    }
}
