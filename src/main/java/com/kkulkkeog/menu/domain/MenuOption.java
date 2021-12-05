package com.kkulkkeog.menu.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MENU_OPTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"menu"})
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuOption")
    private Long no;

    private String name;

    private int menuOptionOrder;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuOption")
    private List<MenuOptionDetail> menuOptionDetails;
}
