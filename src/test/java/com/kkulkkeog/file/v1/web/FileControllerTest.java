package com.kkulkkeog.file.v1.web;


import com.kkulkkeog.file.v1.config.FileProperty;
import com.kkulkkeog.file.v1.domain.File;
import com.kkulkkeog.file.v1.repository.FileRepository;
import com.kkulkkeog.file.v1.service.FileServiceImpl;
import com.kkulkkeog.file.v1.service.SimpleFileSave;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.io.IOException;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = { FileController.class })
@Import({FileServiceImpl.class, SimpleFileSave.class})
@Slf4j
class FileControllerTest {

    WebTestClient webClient;

    @MockBean
    FileRepository fileRepository;

    @MockBean
    FileProperty fileProperty;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void setup() {
        this.webClient = WebTestClient
                .bindToApplicationContext(this.context)
                .apply(springSecurity())
                .configureClient()
                .filter(basicAuthentication())
                .build();
    }

    void after() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("upload");
        java.io.File file = classPathResource.getFile();


        for (java.io.File f:file.listFiles()) {
            log.info("after: {}", f.getName());
            f.delete();
        }
    }

    @Test
    @WithMockUser
    @DisplayName("단건 파일 저장")
    void testPostFile(){
        ClassPathResource classPathResource = new ClassPathResource("images/포대자루.jpeg");
        log.info("classPathResource path: {}", classPathResource.getPath());
        log.info("classPathResource filename: {}", classPathResource.getFilename());

        Mockito.when(fileProperty.getBasePath()).thenReturn("src/test/resources/upload/");
        Mockito.when(fileRepository.save(Mockito.any(File.class))).thenReturn(File.builder().fileNo(1L).build());

        webClient
                .mutateWith(csrf())
                .post()
                .uri("/api/v1/files")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("files", classPathResource))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.fileNo").isEqualTo(1);
    }



}
