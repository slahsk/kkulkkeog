package com.kkulkkeog.member.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"member"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    private Long no;

    private String title;

    private String address;

    private String message;

    private int phoneNumber;

    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private  Member member;
}
