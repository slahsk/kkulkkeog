package com.kkulkkeog.file.service;

import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface FileService {
    Mono<Long> saveFile(Mono<FilePart> filePartMono);
}
