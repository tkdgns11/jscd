package com.jscd.app.order.dao;

import com.jscd.app.order.dto.OrderDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public OrderDaoImpl(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public OrderDTO getOrder(int registCode) {
        return sqlSession.selectOne("com.jscd.app.order.orderMapper.getOrder", registCode);
    }
}