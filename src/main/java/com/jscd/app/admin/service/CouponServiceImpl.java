package com.jscd.app.admin.service;

import com.jscd.app.admin.dao.CouponDao;
import com.jscd.app.admin.dao.CouponInfoDao;
import com.jscd.app.admin.dto.CouponDto;
import com.jscd.app.admin.dto.CouponInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponInfoDao couponInfoDao;

    @Autowired
    private CouponDao couponDao;

    @Override
    public List<CouponInfoDto> GetCouponInfoList() {
        return couponInfoDao.couponInfoList();
    }

    @Override
    public int registerCoupons(List<CouponDto> coupons) throws Exception {

        for (int i = 0; i < coupons.size(); i++) {
            CouponDto coupon = coupons.get(i);
            coupon.setUseAvailable('y');
            coupon.setCouponHisCode(1);
            couponDao.insertCoupon(coupon);
        }

        return coupons.size();
    }

    @Override
    public int checkCoupon(String couponID) throws Exception {
        return couponDao.selectByCouponID(couponID);
    }

    public int useCoupon(String couponID) throws Exception {
        return couponDao.selectByCouponID(couponID);
    }
}