package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.common.exception.ReviewIllegalArgumentException;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

    @InjectMocks
    ReviewServiceImpl reviewService;

    @Mock
    ReviewRepository reviewRepository;

    Review request;

    Review data;

    @BeforeEach
    void setup(){
        request = Review.builder()
                .orderNo(10L)
                .userNo(999L)
                .reviewMessage("맛있쩡")
                .deleted(false)
                .build();

        data = Review.builder()
                .shopNo(10L)
                .userNo(999L)
                .reviewMessage("맛있쩡")
                .deleted(false)
                .build();
    }


    @Test
    @DisplayName("리뷰 중복 확인")
    void testSaveReviewReviewIllegalArgumentException() {

        when(reviewRepository.findByOrderNoAndUserNo(anyLong(), anyLong())).thenReturn(Optional.of(data));

        Mono<Review> reviewMono = reviewService.saveReview(request);

        StepVerifier
                .create(reviewMono)
                .expectError(ReviewIllegalArgumentException.class)
                .verify();

    }

    @Test
    @DisplayName("리뷰 삭제 한다음에 새로 등록")
    void testSaveReview(){
        data.setDeleted(true);

        when(reviewRepository.findByOrderNoAndUserNo(anyLong(), anyLong())).thenReturn(Optional.of(data));
        when(reviewRepository.save(any(Review.class))).thenReturn(request);

        Mono<Review> reviewMono = reviewService.saveReview(request);

        StepVerifier
                .create(reviewMono)
                .expectNextCount(1)
                .verifyComplete();

        verify(reviewRepository, times(1)).save(any(Review.class));
    }
}