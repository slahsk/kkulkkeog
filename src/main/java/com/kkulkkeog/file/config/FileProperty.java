package com.kkulkkeog.file.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Builder
@Configuration
@ConfigurationProperties("file")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileProperty {
    String basePath;
}
