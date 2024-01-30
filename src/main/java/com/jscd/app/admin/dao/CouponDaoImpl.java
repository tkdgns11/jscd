package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.CouponDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponDaoImpl implements CouponDao {

    @Autowired
    private final SqlSession sqlSession;

    @Autowired
    private static final String namespace = "com.jscd.app.mapper.CouponMapper.";

    public CouponDaoImpl(SqlSession sqlSession) throws Exception {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertCoupons(List<CouponDto> coupons) throws Exception {
        return sqlSession.insert(namespace + "insertCoupons", coupons);
    }

    @Override
    public void insertCoupon(CouponDto coupon) throws Exception {
        sqlSession.insert("insertCoupon", coupon);
    }

    @Override
    public int selectByCouponID(String couponID) throws Exception{
        return sqlSession.selectOne(namespace + "selectByCouponID", couponID);
    }
}