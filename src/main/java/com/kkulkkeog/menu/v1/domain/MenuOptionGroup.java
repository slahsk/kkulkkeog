package com.kkulkkeog.menu.v1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuOptionGroupNo;

    private String menuOptionGroupName;

    private Integer menuOptionGroupOrder;

    @ManyToOne
    @JoinColumn(name = "menu_no")
    private Menu menu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuOptionGroup")
    private List<MenuOption> menuOptions;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;
}
