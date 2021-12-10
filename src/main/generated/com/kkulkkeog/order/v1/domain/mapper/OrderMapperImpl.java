package com.kkulkkeog.order.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice.CouponCalculatePriceBuilder;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation.CouponValidationBuilder;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.api.message.MenuValidation.MenuValidationBuilder;
import com.kkulkkeog.order.v1.domain.Order;
import com.kkulkkeog.order.v1.domain.OrderCoupon;
import com.kkulkkeog.order.v1.domain.OrderMenu;
import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import com.kkulkkeog.payment.v1.api.message.OrderPayment.OrderPaymentBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:21:17+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<MenuValidation> toMenuValidations(List<OrderMenu> orderMenus) {
        if ( orderMenus == null ) {
            return null;
        }

        List<MenuValidation> list = new ArrayList<MenuValidation>( orderMenus.size() );
        for ( OrderMenu orderMenu : orderMenus ) {
            list.add( orderMenuToMenuValidation( orderMenu ) );
        }

        return list;
    }

    @Override
    public List<CouponValidation> toCouponValidations(List<OrderCoupon> orderCoupons) {
        if ( orderCoupons == null ) {
            return null;
        }

        List<CouponValidation> list = new ArrayList<CouponValidation>( orderCoupons.size() );
        for ( OrderCoupon orderCoupon : orderCoupons ) {
            list.add( orderCouponToCouponValidation( orderCoupon ) );
        }

        return list;
    }

    @Override
    public OrderPayment toOrderPayment(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderPaymentBuilder orderPayment = OrderPayment.builder();

        if ( order.getOrderNo() != null ) {
            orderPayment.orderNo( order.getOrderNo() );
        }
        orderPayment.resultPrice( order.getResultPrice() );
        orderPayment.memberNo( order.getMemberNo() );
        orderPayment.paymentType( order.getPaymentType() );

        return orderPayment.build();
    }

    @Override
    public CouponCalculatePrice toCouponCalculatePrice(Order order) {
        if ( order == null ) {
            return null;
        }

        CouponCalculatePriceBuilder couponCalculatePrice = CouponCalculatePrice.builder();

        couponCalculatePrice.orderTotalPrice( order.getTotalPrice() );
        couponCalculatePrice.couponNos( orderCouponListToLongList( order.getOrderCoupons() ) );

        return couponCalculatePrice.build();
    }

    protected MenuValidation orderMenuToMenuValidation(OrderMenu orderMenu) {
        if ( orderMenu == null ) {
            return null;
        }

        MenuValidationBuilder menuValidation = MenuValidation.builder();

        menuValidation.menuNo( orderMenu.getMenuNo() );
        menuValidation.price( (int) orderMenu.getPrice() );

        return menuValidation.build();
    }

    protected CouponValidation orderCouponToCouponValidation(OrderCoupon orderCoupon) {
        if ( orderCoupon == null ) {
            return null;
        }

        CouponValidationBuilder couponValidation = CouponValidation.builder();

        couponValidation.memberNo( orderCoupon.getMemberNo() );
        couponValidation.shopNo( orderCoupon.getShopNo() );

        return couponValidation.build();
    }

    protected List<Long> orderCouponListToLongList(List<OrderCoupon> list) {
        if ( list == null ) {
            return null;
        }

        List<Long> list1 = new ArrayList<Long>( list.size() );
        for ( OrderCoupon orderCoupon : list ) {
            list1.add( OrderMapper.longToOrderCouponNo( orderCoupon ) );
        }

        return list1;
    }
}
