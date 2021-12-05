package com.kkulkkeog.coupon.repository;

import com.kkulkkeog.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
