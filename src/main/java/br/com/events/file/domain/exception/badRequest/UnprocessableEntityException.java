package br.com.events.file.domain.exception.badRequest;

import br.com.events.file.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(
            final String message, final String description
    ) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY.value(), message, description);
    }
}
