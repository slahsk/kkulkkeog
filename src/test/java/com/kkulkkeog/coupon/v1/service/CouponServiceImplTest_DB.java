package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.config.DataSourceConfig;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

@Transactional
@SpringBootTest
@ActiveProfiles({"test"})
class CouponServiceImplTest_DB {


    @Autowired
    CouponRepository couponRepository;

    @Test
    void testSaveCouponUser(){
        Coupon coupon = Coupon.builder()
                .build();
        Example<Coupon> of = Example.of(coupon);
        List<String> dd = List.of("dd");
        Sort couponNo = Sort.by(Sort.Direction.DESC, "couponNo");
        Page<Coupon> all = couponRepository.findAll(of, PageRequest.of(0, 5, couponNo));

        all.get().forEach(coupon1 -> {
            System.out.println(coupon1);
        });

        System.out.println(all.getTotalPages());
        System.out.println(all.getSize());
        System.out.println(all.getNumber());


        Assertions.assertEquals(1,1);
    }


}
