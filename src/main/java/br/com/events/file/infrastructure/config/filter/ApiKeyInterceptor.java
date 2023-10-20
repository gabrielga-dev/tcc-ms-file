package br.com.events.file.infrastructure.config.filter;

import br.com.events.file.domain.exception.interceptor.InvalidApiKeyException;
import br.com.events.file.domain.exception.interceptor.NoApiKeyReceivedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * This class makes the request filtering so only consumers with allowed api-key can access this microservice's
 * features
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ApiKeyInterceptor implements HandlerInterceptor {

    @Value("${valid.api.keys}")
    private List<String> validApiKeys;

    @Value("${api.key.header}")
    private String apiKeyHeader;

    @Override
    public boolean preHandle(
            final HttpServletRequest request, final HttpServletResponse response, final Object handler
    ) throws Exception {
        if (
                HttpMethod.GET.name().equals(request.getMethod()) &&
                        request.getRequestURL().toString().contains("/v1/file/image")
        ) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        var apiKey = Optional.ofNullable(request.getHeader(apiKeyHeader))
                .orElseThrow(NoApiKeyReceivedException::new);
        if (validApiKeys.contains(apiKey)) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        throw new InvalidApiKeyException();
    }
}
