package com.kkulkkeog.config;

import com.kkulkkeog.file.config.FileProperty;
import com.kkulkkeog.file.service.FileSave;
import com.kkulkkeog.file.service.SimpleFileSave;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileSaveConfig {

    @Bean
    public FileSave fileSave(FileProperty fileProperty){
        return new SimpleFileSave(fileProperty);
    }
}
