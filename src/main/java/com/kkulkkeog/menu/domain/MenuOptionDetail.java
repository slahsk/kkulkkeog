package com.kkulkkeog.menu.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_MENU_OPTION_DETAIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"menuOption"})
public class MenuOptionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuOptionDetail")
    private Long no;

    private String name;

    private int menuOptionDetailOrder;

    @ManyToOne
    @JoinColumn(name = "menu_option_no")
    private MenuOption menuOption;
}
