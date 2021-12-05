package com.kkulkkeog.review.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class ReviewController {
    private final ReviewService reviewService;


}
