package com.kkulkkeog.menu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
