package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.common.exception.MenuValidationException;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.domain.Menu;
import com.kkulkkeog.menu.v1.repository.MenuGroupRepository;
import com.kkulkkeog.menu.v1.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MenuServiceImplTest {

    @InjectMocks
    MenuServiceImpl menuService;

    @Mock
    MenuGroupRepository menuGroupRepository;

    @Mock
    MenuRepository menuRepository;


    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("메뉴 검사 - 성공")
    void testOrderValidationTrue(){
        MenuValidation menuValidation = MenuValidation.builder().menuNo(1).shopNo(100).price(2000).build();
        MenuValidation menuValidation2 = MenuValidation.builder().menuNo(2).shopNo(100).price(4000).build();

        List<MenuValidation> menuValidations = List.of(menuValidation, menuValidation2);

        Menu value = Menu.builder().menuNo(1L).shopNo(100L).price(2000).build();
        Menu value2 = Menu.builder().menuNo(2L).shopNo(100L).price(4000).build();

        when(menuRepository.findAllById(anyList())).thenReturn(List.of(value, value2));



        StepVerifier.create(menuService.validationOrderMenu(menuValidations))
                .expectNextCount(2)
                .expectComplete()
                .log()
                .verify();
    }

    @Test
    @DisplayName("메뉴 검사 - 실패(MenuValidationException)")
    void testOrderValidationMenuValidationException(){
        MenuValidation menuValidation = MenuValidation.builder().menuNo(1).shopNo(100).price(2000).build();
        MenuValidation menuValidation2 = MenuValidation.builder().menuNo(2).shopNo(100).price(4000).build();

        List<MenuValidation> menuValidations = List.of(menuValidation, menuValidation2);

        Menu value = Menu.builder().menuNo(1L).shopNo(100L).price(3000).build();
        Menu value2 = Menu.builder().menuNo(2L).shopNo(100L).price(4000).build();

        when(menuRepository.findAllById(anyList())).thenReturn(List.of(value, value2));


        StepVerifier.create(menuService.validationOrderMenu(menuValidations))
                .expectError(MenuValidationException.class)
                .verify();

    }
}
