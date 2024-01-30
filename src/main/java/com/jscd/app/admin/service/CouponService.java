package com.jscd.app.admin.service;

import com.jscd.app.admin.dto.CouponDto;
import com.jscd.app.admin.dto.CouponInfoDto;

import java.util.List;

public interface CouponService {

    List<CouponInfoDto> GetCouponInfoList();

    int registerCoupons(List<CouponDto> coupons) throws Exception;

    int checkCoupon(String couponID) throws Exception;
}
