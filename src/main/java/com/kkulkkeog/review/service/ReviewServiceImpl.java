package com.kkulkkeog.review.service;

import com.kkulkkeog.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository repository;


}
