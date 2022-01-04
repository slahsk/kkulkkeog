package com.kkulkkeog.coupon.v1.repository;

import com.kkulkkeog.coupon.v1.domain.CouponUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CouponUserRepository extends JpaRepository<CouponUser, Long> {

    Optional<CouponUser> findByCouponNo(long couponNo);

}
