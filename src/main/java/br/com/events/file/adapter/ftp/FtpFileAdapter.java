package br.com.events.file.adapter.ftp;

import br.com.events.file.business.exception.file.RetrieveFileException;
import br.com.events.file.business.exception.file.UploadFileException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class FtpFileAdapter {

    @Value("${ftp.server.server}")
    private String server;
    @Value("${ftp.server.port}")
    private int port;
    @Value("${ftp.server.user}")
    private String user;
    @Value("${ftp.server.password}")
    private String password;

    private FTPClient getClient() {
        try {
            FTPClient ftpClient = new FTPClient();

            ftpClient.connect(server, port);
            ftpClient.login(user, password);
            ftpClient.enterLocalPassiveMode();

            return ftpClient;
        } catch (IOException ex) {
            log.error(
                    "Error at logging into FTP server: \n username: {} \n password: {} \n server: {} \n port: {}",
                    user, password, server, port
            );
            throw new RetrieveFileException();
        }
    }

    public byte[] getFile(String remoteFilePath) {
        var ftpClient = getClient();
        try {
            try {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                var inputStream = ftpClient.retrieveFileStream(remoteFilePath);

                return inputStream.readAllBytes();
            } catch (Exception ex) {
                log.error("Error at finding file: {}", ex.getMessage());
                throw new RetrieveFileException();
            } finally {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ex) {
            log.error("Error at logging out or disconnecting from FTP server");
            throw new RetrieveFileException();
        }
    }

    public void uploadFile(String fileName, MultipartFile multipartFile) {
        var ftpClient = getClient();
        try {
            var inputStream = multipartFile.getInputStream();
            try {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                var returned = ftpClient.storeFile(fileName, inputStream);

                log.info("File uploading: {}", returned);
                if (!returned){
                    throw new UploadFileException();
                }
            } catch (Exception ex) {
                log.error("Error at uploading file: {}", ex.getMessage());
                throw new UploadFileException();
            } finally {
                ftpClient.logout();
                ftpClient.disconnect();
            }
            inputStream.close();
        } catch (IOException ex) {
            log.error("Error at logging out or disconnecting from FTP server");
            throw new UploadFileException();
        }
    }
}
