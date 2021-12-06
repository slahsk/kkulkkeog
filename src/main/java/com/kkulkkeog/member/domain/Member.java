package com.kkulkkeog.member.domain;

import lombok.*;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member")
    private Long no;

    private String email;

    private String memberId;

    private String password;

    private String name;

    private Boolean deleted;

    @CreatedDate
    private LocalDateTime created;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<MemberCoupon> memberCoupons;

    public void delete() {
        this.deleted = true;
    }
}
