package com.kkulkkeog.coupon.v1.repository;

import com.kkulkkeog.coupon.v1.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
