package com.kkulkkeog.config;

import com.kkulkkeog.file.v1.config.FileProperty;
import com.kkulkkeog.file.v1.service.FileSave;
import com.kkulkkeog.file.v1.service.SimpleFileSave;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileSaveConfig {

    @Bean
    public FileSave fileSave(FileProperty fileProperty){
        return new SimpleFileSave(fileProperty);
    }
}
