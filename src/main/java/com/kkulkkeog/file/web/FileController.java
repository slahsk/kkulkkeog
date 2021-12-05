package com.kkulkkeog.file.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.file.api.web.PostFileResponse;
import com.kkulkkeog.file.domain.mapper.FileMapper;
import com.kkulkkeog.file.service.FileService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class FileController {

    private final FileService fileService;

    @PostMapping("/files")
    public Mono<PostFileResponse> postFile(@RequestPart("files") Mono<FilePart> filePartMono){


        return fileService.saveFile(filePartMono)
                .map( fileNo -> new PostFileResponse(fileNo));
    }
}
