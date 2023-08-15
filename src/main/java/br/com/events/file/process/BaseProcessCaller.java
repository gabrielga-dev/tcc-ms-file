package br.com.events.file.process;

/**
 * This interface will be implemented by classes to execute a chain of micro processes but with void return
 *
 * @param <T> the class that will be passed as parameter
 * @param <R> the class that will be passed as return
 * @author Gabriel Guimarães de Almeida
 */
public interface BaseProcessCaller<T, R> {

    void callProcesses(T param);
}
