package com.kkulkkeog.menu.v1.domain;

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
@ToString(exclude = {"menuGroup"})
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMenu")
    private Long menuNo;

    private String menuName;

    private long shopNo;

    private int price;

    private int salesRate;

    private String menuDescription;

    private int menuOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_group_no")
    private MenuGroup menuGroup;

    private long fileNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuOptionGroup> menuOptions;

}