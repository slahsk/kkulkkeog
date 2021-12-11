package com.kkulkkeog.coupon.v1.repository;

import com.kkulkkeog.coupon.v1.domain.CouponUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponUserRepository extends JpaRepository<CouponUser, Long> {

    List<CouponUser> findAllBy
}
