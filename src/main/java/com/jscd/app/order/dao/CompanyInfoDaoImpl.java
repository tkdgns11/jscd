package com.jscd.app.order.dao;

import com.jscd.app.order.dto.CompanyInfoDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyInfoDaoImpl implements CompanyInfoDao {
    private static final String NAMESPACE = "com.jscd.app.order.CompanyInfoMapper";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public CompanyInfoDTO select(int slrNo) {

        System.out.println("dao company");
        return sqlSession.selectOne(NAMESPACE + ".select", slrNo);
    }
}
