package com.kkulkkeog.menu.v1.domain;

import java.time.LocalDateTime;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "TB_MENU_GROUP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuGroupNo;

    private Long shopNo;

    private String menuGroupName;

    private String menuGroupDescription;

    private int menuGroupOrder;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "menuGroup")
    private List<Menu> menus;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;

}
