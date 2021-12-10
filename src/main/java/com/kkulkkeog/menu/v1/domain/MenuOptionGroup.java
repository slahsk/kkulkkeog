package com.kkulkkeog.menu.v1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MENU_OPTION_GROUP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"menu"})
public class MenuOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMenuOptionGroup")
    private Long menuOptionGroupNo;

    private String menuOptionGroupName;

    private int menuOptionGroupOrder;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuOptionGroup")
    private List<MenuOption> menuOptions;
}
