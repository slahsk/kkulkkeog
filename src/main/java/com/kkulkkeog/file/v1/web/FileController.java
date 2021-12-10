package com.kkulkkeog.file.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.file.v1.api.web.PostFileResponse;
import com.kkulkkeog.file.v1.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class FileController {

    private final FileService fileService;

    @PostMapping("/files")
    public Mono<PostFileResponse> postFile(@RequestPart("files") Mono<FilePart> filePartMono){


        return fileService.saveFile(filePartMono)
                .map( fileNo -> new PostFileResponse(fileNo));
    }
}
