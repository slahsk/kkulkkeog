package com.kkulkkeog.file.web;


import com.kkulkkeog.file.config.FileProperty;
import com.kkulkkeog.file.domain.File;
import com.kkulkkeog.file.repository.FileRepository;
import com.kkulkkeog.file.service.FileServiceImpl;
import com.kkulkkeog.file.service.SimpleFileSave;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = { FileController.class })
@Import({FileServiceImpl.class, SimpleFileSave.class})
@Slf4j
public class FileControllerTest {

    @Autowired
    WebTestClient webClient;

    @MockBean
    FileRepository fileRepository;

    @MockBean
    FileProperty fileProperty;

    void after() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("upload");
        java.io.File file = classPathResource.getFile();


        for (java.io.File f:file.listFiles()) {
            log.info("after: {}", f.getName());
            f.delete();
        }
    }


    @Test
    void testPostFile(){
        ClassPathResource classPathResource = new ClassPathResource("images/포대자루.jpeg");
        log.info("classPathResource path: {}", classPathResource.getPath());
        log.info("classPathResource filename: {}", classPathResource.getFilename());

        Mockito.when(fileProperty.getBasePath()).thenReturn("src/test/resources/upload/");
        Mockito.when(fileRepository.save(Mockito.any(File.class))).thenReturn(File.builder().no(1L).build());

        webClient.post()
                .uri("/api/v1/files")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("files", classPathResource))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.fileNo").isEqualTo(1);
    }



}
