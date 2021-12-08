package com.kkulkkeog.menu.service;

import com.kkulkkeog.menu.api.exception.MenuValidationException;
import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.repository.MenuGroupRepository;
import com.kkulkkeog.menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
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
    @DisplayName("메뉴 검사 응답값 성공")
    void testOrderValidationTrue(){
        MenuValidation menuValidation = MenuValidation.builder().menuNo(1).shopNo(100).price(2000).build();
        MenuValidation menuValidation2 = MenuValidation.builder().menuNo(2).shopNo(100).price(4000).build();

        List<MenuValidation> menuValidations = List.of(menuValidation, menuValidation2);

        Optional<Integer> value = Optional.of(1);
        Optional<Integer> value2 = Optional.of(1);
        when(menuRepository.countByShopNoAndMenuNoAndPrice(anyLong(), anyLong(), anyInt())).thenReturn(value, value2);



        StepVerifier.create(menuService.validationOrderMenu(menuValidations).log())
                .expectNext(true)
                .expectComplete()
                .log()
                .verify();
    }

    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("메뉴 검사 응답값 실패(MenuValidationException)")
    void testOrderValidationMenuValidationException(){
        MenuValidation menuValidation = MenuValidation.builder().menuNo(1).shopNo(100).price(2000).build();
        MenuValidation menuValidation2 = MenuValidation.builder().menuNo(2).shopNo(100).price(4000).build();

        List<MenuValidation> menuValidations = List.of(menuValidation, menuValidation2);

        Optional<Integer> value = Optional.of(1);
        Optional<Integer> value2 = Optional.of(0);
        when(menuRepository.countByShopNoAndMenuNoAndPrice(anyLong(), anyLong(), anyInt())).thenReturn(value, value2);



        StepVerifier.create(menuService.validationOrderMenu(menuValidations))
                .expectError(MenuValidationException.class)
                .verify();

    }
}
