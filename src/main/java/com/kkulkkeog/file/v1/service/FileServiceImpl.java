package com.kkulkkeog.file.v1.service;

import com.kkulkkeog.file.v1.common.exception.FileNotCreateException;
import com.kkulkkeog.file.v1.domain.File;
import com.kkulkkeog.file.v1.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FileServiceImpl implements FileService{
    private final FileRepository fileRepository;

    private final FileSave fileSave;

    @Override
    public Mono<Long> saveFile(Mono<FilePart> filePartMono) {
        return filePartMono
                .flatMap( filePart -> {
                    File file = fileRepository.save(File.builder().name(filePart.filename()).build());

                    return fileSave.save(filePart, file)
                            .map(f -> {
                                boolean createdFile = fileSave.hasFile(f.getPath(), f.getSize());

                                if(createdFile){
                                    f.setCreatedFile(true);
                                }else{
                                    throw new FileNotCreateException(f.toString());
                                }

                                return f.getNo();
                            });
                });
    }
}
