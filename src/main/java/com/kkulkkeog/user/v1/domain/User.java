package com.kkulkkeog.user.v1.domain;

import com.kkulkkeog.user.v1.api.UserLoginType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    private String email;

    private String password;

    private String userName;

    private String cellPhoneNumber;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private String defaultAddress;

    @Enumerated(EnumType.STRING)
    private UserLoginType userLoginType;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Boolean deleted;


}
