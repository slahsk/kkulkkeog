package com.kkulkkeog.menu.domain;

import com.kkulkkeog.shop.domain.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MENU_GROUP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuGroup")
    private Long no;

    private Long shopNo;

    private String name;

    private String message;

    private int menuGroupOrder;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuGroup")
    private List<Menu> menus;

}
