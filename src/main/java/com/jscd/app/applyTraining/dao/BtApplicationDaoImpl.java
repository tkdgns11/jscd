package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BtApplicationDaoImpl implements BtApplicationDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.applyTraining.btApplicationMapper.";

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace + "count");
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int delete(Integer stfmNo) throws Exception{
        return session.delete(namespace + "delete", stfmNo);
    }

    @Override
    public List<BtApplicationDto> selectAll() throws Exception{
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public BtApplicationDto select(Integer stfmNo) throws Exception{
        return session.selectOne(namespace + "select", stfmNo);
    }

    @Override
    public List<BtApplicationDto> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public int update(BtApplicationDto dto) throws Exception{
        return session.update(namespace + "update", dto);
    }

    @Override
    public int insert(BtApplicationDto dto) throws Exception{
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public BtApplicationDto confirmApplcation(Map map) throws Exception{
        return session.selectOne(namespace + "confirmApplication", map);
    }
}
