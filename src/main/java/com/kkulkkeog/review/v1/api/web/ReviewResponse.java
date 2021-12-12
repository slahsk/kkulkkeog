package com.kkulkkeog.review.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ReviewResponse {

    private Long reviewNo;

    private Long shopNo;

    private Long userNo;

    private Long fileNo;

    private String userName;

    private String reviewMessage;

    private Float reviewScore;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Boolean deleted;
}
