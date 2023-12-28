package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.CouponInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponInfoDaoImpl implements CouponInfoDao {

    @Autowired
    private final SqlSession sqlSession;

    @Autowired
    private static final String namespace = "com.jscd.app.mapper.CouponInfoMapper.";

    public CouponInfoDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<CouponInfoDto> couponInfoList() {
        return sqlSession.selectList(namespace + "selectAll") ;
    }

}