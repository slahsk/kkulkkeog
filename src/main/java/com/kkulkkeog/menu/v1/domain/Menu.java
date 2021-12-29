package com.kkulkkeog.menu.v1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuNo;

    private String menuName;

    private Long shopNo;

    private Integer price;

    private String menuDescription;

    private Integer menuOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_group_no")
    private MenuGroup menuGroup;

    private Long fileNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuOptionGroup> menuOptions;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;

    public boolean validation(long shopNo, int price){
        return this.shopNo == shopNo && this.price == price;
    }

}
