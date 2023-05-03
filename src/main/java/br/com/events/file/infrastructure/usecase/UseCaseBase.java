package br.com.events.file.infrastructure.usecase;

/**
 * This interface dictates which methods are needed to implement when a usecase is needed
 *
 * @author Gabriel Guimarães de Almeida
 */
public interface UseCaseBase<T, R> {

    R execute(T param);
}
