package com.kkulkkeog.coupon.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.web.CouponResponse;
import com.kkulkkeog.coupon.v1.api.web.CouponResponse.CouponResponseBuilder;
import com.kkulkkeog.coupon.v1.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.v1.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.domain.Coupon.CouponBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:19:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class CouponMapperImpl implements CouponMapper {

    @Override
    public Coupon toCoupon(GetCouponsRequest getCouponsRequest) {
        if ( getCouponsRequest == null ) {
            return null;
        }

        CouponBuilder coupon = Coupon.builder();

        if ( getCouponsRequest.getMemberNo() != null ) {
            coupon.memberNo( Long.parseLong( getCouponsRequest.getMemberNo() ) );
        }

        return coupon.build();
    }

    @Override
    public CouponResponse toGetCouponResponse(Coupon coupon) {
        if ( coupon == null ) {
            return null;
        }

        CouponResponseBuilder couponResponse = CouponResponse.builder();

        if ( coupon.getCouponNo() != null ) {
            couponResponse.couponNo( coupon.getCouponNo() );
        }
        couponResponse.memberNo( coupon.getMemberNo() );
        couponResponse.shopNo( coupon.getShopNo() );
        couponResponse.minimumPrice( coupon.getMinimumPrice() );
        couponResponse.couponIssuance( coupon.getCouponIssuance() );
        couponResponse.startTime( coupon.getStartTime() );
        couponResponse.endTime( coupon.getEndTime() );
        couponResponse.availableCoupon( coupon.isAvailableCoupon() );
        couponResponse.usedTime( coupon.getUsedTime() );
        couponResponse.created( coupon.getCreated() );
        couponResponse.updated( coupon.getUpdated() );

        return couponResponse.build();
    }

    @Override
    public Coupon toCoupon(PostCouponRequest postCouponRequest) {
        if ( postCouponRequest == null ) {
            return null;
        }

        CouponBuilder coupon = Coupon.builder();

        coupon.memberNo( postCouponRequest.getMemberNo() );
        coupon.shopNo( postCouponRequest.getShopNo() );
        coupon.minimumPrice( postCouponRequest.getMinimumPrice() );
        coupon.couponIssuance( postCouponRequest.getCouponIssuance() );
        coupon.startTime( postCouponRequest.getStartTime() );
        coupon.endTime( postCouponRequest.getEndTime() );

        return coupon.build();
    }
}
