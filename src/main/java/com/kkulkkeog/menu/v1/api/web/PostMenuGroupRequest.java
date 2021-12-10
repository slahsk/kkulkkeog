package com.kkulkkeog.menu.v1.api.web;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostMenuGroupRequest {

    private String menuGroupName;

    private String menuGroupDescription;

    private int menuGroupOrder;



}
