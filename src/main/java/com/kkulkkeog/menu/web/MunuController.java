package com.kkulkkeog.menu.web;

import com.kkulkkeog.common.Constant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class MunuController {

    @PostMapping("/menus")
    public void postMenu(){

    }
}
