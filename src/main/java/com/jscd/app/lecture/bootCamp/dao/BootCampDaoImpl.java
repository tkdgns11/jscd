package com.jscd.app.lecture.bootCamp.dao;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BootCampDaoImpl implements BootCampDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.bootCamp.bootCampMapper.";

    @Override
    public BootCampDto selectBoot(String classEnrollNo) throws Exception {
       return session.selectOne(namespace + "select", classEnrollNo);
    }

    @Override
    public int insertBootCamp(BootCampDto bootCampDto) throws Exception {
        return session.insert(namespace + "insert", bootCampDto);
    }

    @Override
    public List<BootCampDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public List<BootCampDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }
}
