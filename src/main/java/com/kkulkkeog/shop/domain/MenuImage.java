package com.kkulkkeog.shop.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_MENU_IMAGE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuImage")
    private Long no;

    private String path;

    private int menuImageOrder;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;
}
