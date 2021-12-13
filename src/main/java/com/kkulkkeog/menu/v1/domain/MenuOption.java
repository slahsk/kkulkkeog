package com.kkulkkeog.menu.v1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_MENU_OPTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"menuOptionGroup"})
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuOptionNo;

    private String name;

    private int menuOptionDetailOrder;

    @ManyToOne
    @JoinColumn(name = "menu_option_group_no")
    private MenuOptionGroup menuOptionGroup;
}
