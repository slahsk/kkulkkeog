package com.kkulkkeog.menu.v1.api.web;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PutMenuGroupRequest {

    private String menuGroupName;

    private String menuGroupDescription;

    private Integer menuGroupOrder;
}
