package com.kkulkkeog.menu.domain;

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

    private long imageNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuOption> menuOptions;

}
