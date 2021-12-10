package com.kkulkkeog.file.v1.api.web;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
public class PostFileResponse {
    private long fileNo;

    public PostFileResponse(Long fileNo) {
        this.fileNo = fileNo;
    }
}
