package com.kkulkkeog.review.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PutReviewCommentRequest {

    private String reviewComment;

}
