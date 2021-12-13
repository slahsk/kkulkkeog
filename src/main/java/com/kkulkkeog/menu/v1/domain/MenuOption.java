package com.kkulkkeog.menu.v1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private String menuOptionName;

    private Integer menuOptionOrder;

    @ManyToOne
    @JoinColumn(name = "menu_option_group_no")
    private MenuOptionGroup menuOptionGroup;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;
}
