package com.kkulkkeog.review.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_REVIEW")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReview")
    private Long no;

}
