package com.kkulkkeog.file.service;

import com.kkulkkeog.file.config.FileProperty;
import com.kkulkkeog.file.domain.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Slf4j
public class SimpleFileSave implements FileSave{

     private final FileProperty fileProperty;

    @Override
    public Mono<File> save(FilePart filePart, File file) {
        Path path = Paths.get(fileProperty.getBasePath()).resolve(String.valueOf(file.getNo()));
        log.debug("SimpleFileSave: {}", path.getFileName());
        log.debug("SimpleFileSave: {}", path.toAbsolutePath());

        return filePart.transferTo(path)
                .then(Mono.fromCallable( () -> {
            file.setPath(path.toAbsolutePath().toString());

            try {
                long size = Files.size(path);
                log.debug("SimpleFileSave: {}", size);
                file.setSize(size);
            } catch (IOException e) {
                log.error("SimpleFileSave.save",e);
            }

            return file;
        }));
    }

    @Override
    public boolean hasFile(String path, long size) {
        Path filePath = Paths.get(path);
        try {
            long fileSize = Files.size(filePath);

            return size == fileSize;
        } catch (IOException e) {
            log.error("SimpleFileSave.hasFile",e);
        }


        return false;
    }


}
