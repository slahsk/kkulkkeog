package com.kkulkkeog.file.v1.service;

import com.kkulkkeog.file.v1.domain.File;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface FileSave {

    Mono<File> save(FilePart filePart, File file);

    boolean hasFile(String path, long size);
}
