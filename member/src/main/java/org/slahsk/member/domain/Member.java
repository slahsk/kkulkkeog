package org.slahsk.member.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member")
    private Long no;

    private String email;

    private String id;

    private String password;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Address> addresses;

}
