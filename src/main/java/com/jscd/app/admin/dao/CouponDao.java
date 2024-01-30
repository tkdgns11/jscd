package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.CouponDto;

import java.util.List;

public interface CouponDao {

    int insertCoupons(List<CouponDto> coupons) throws Exception;

    void insertCoupon(CouponDto coupon) throws Exception;

    int selectByCouponID(String couponID) throws Exception;
}
