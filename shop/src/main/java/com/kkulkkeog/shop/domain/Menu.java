package com.kkulkkeog.shop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MENU")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu")
    private Long no;

    private String name;

    private int price;

    private int salesRate;

    private String message;

    private int menuOrder;

    private boolean recommend;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_group_no")
    private MenuGroup menuGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuImage> menuImages;
}
