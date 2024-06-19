package br.com.events.file.adapter.file.ftp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "file.technology", havingValue = "ftp")
public class FtpConfiguration {
}
