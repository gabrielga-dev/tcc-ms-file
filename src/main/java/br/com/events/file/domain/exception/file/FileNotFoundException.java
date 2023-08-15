package br.com.events.file.domain.exception.file;

import br.com.events.file.domain.exception.badRequest.NotFoundException;

public class FileNotFoundException extends NotFoundException {

    public FileNotFoundException() {
        super(
                "Não foi possível encontrar o arquivo!",
                "Não foi encontrado nenhum arquivo com as credenciais informadas!"
        );
    }
}
