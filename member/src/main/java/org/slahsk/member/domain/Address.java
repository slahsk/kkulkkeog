package org.slahsk.member.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    private Long no;

    private String title;

    private String address;

    private String message;

    private int phoneNumber;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private  Member member;
}
