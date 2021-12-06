package com.kkulkkeog.member.domain;

import lombok.*;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEMBER_COUPON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"member"})
@EntityListeners(AuditingEntityListener.class)
public class MemberCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    private Long no;

    private long couponNo;

    private boolean used;

    @CreatedDate
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private  Member member;
}
