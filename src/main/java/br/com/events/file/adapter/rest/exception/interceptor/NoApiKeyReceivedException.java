package br.com.events.file.adapter.rest.exception.interceptor;

import br.com.events.file.adapter.rest.exception.badRequest.BadRequestException;

/**
 * This exception is called when a request with no api-ey is received
 *
 * @author Gabriel Guimarães de Almeida
 */
public class NoApiKeyReceivedException extends BadRequestException {

    public NoApiKeyReceivedException() {
        super(
                "Consumidor nao identificado!",
                "Não pudemos identificar qual é o consumidor do serviço. Identifique-o e tente novamente!"
        );
    }
}
