package com.kkulkkeog.review.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostReviewRequest {

    private Long shopNo;

    private Long userNo;

    private Long fileNo;

    private String userName;

    private String reviewMessage;

    private Float reviewScore;
}
