package com.kkulkkeog.shop.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_SHOP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop")
    private Long no;

    private String name;

    private String address;

    private String message;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<MenuGroup> menuGroups;

}
