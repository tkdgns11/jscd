package com.jscd.app.lecture.seminar.dao;

import com.jscd.app.lecture.seminar.domain.SeminarRegistDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SeminarRegistDaoImpl implements SeminarRegistDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.lecture.seminar.SeminarRegistMapper.";

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace + "count");
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int delete(Integer classEnrollNo, String writer) throws Exception{
        Map map = new HashMap();
        map.put("classEnrollNo", classEnrollNo);
        map.put("writer",writer);
        return session.delete(namespace + "delete", map);
    }

    @Override
    public int insert(SeminarRegistDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public List<SeminarRegistDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public SeminarRegistDto select(Integer classEnrollNo) throws Exception {
        return session.selectOne(namespace + "select", classEnrollNo);
    }

    @Override
    public List<SeminarRegistDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage" , map);
    }

    @Override
    public int update(SeminarRegistDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    @Override
    public int increaseViewCnt(Integer classEnrollNo) throws Exception {
        return session.update(namespace + "increaseViewCnt", classEnrollNo);
    }
}
