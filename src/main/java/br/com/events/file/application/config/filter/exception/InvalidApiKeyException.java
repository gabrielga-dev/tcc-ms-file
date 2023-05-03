package br.com.events.file.application.config.filter.exception;


import br.com.events.file.infrastructure.exception.badRequest.BadRequestException;

/**
 * This exception is called when a request with an invalid key is received
 *
 * @author Gabriel Guimarães de Almeida
 */
public class InvalidApiKeyException extends BadRequestException {

    public InvalidApiKeyException() {
        super(
                "Consumidor inválido!",
                "O consumidor do serviço é inválido. Utilize um válido e tente novamente!"
        );
    }
}
