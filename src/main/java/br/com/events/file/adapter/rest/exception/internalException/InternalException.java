package br.com.events.file.adapter.rest.exception.internalException;

import br.com.events.file.business.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class InternalException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public InternalException(
            final String message, final String description
    ) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, description);
    }
}
