package com.kkulkkeog.file.service;

import com.kkulkkeog.file.domain.File;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

import java.nio.file.Path;

public interface FileSave {

    Mono<File> save(FilePart filePart, File file);

    boolean hasFile(String path, long size);
}
