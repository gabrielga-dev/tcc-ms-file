package br.com.events.file.business.use_case.ftp;

public interface GetFileUseCase {

    byte[] execute(String fileName);
}
