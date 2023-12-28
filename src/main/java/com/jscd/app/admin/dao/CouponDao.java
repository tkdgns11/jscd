package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.CouponDto;

import java.util.List;

public interface CouponDao {

    int insertCoupons(List<CouponDto> coupons);

    void insertCoupon(CouponDto coupon);

    int selectByCouponID(String couponID);
}
