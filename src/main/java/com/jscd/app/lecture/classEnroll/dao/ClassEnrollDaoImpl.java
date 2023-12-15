package com.jscd.app.lecture.classEnroll.dao;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassEnrollDaoImpl implements ClassEnrollDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.jscd.app.lecture.classEnroll.classEnrollMapper.";

    @Override
    public List<ClassEnrollDto> selectAll(Integer courseCode) throws Exception{
        return session.selectList(namespace + "selectAll", courseCode);
    }

    @Override
    public ClassEnrollDto select(Integer classCode) throws Exception {
        return session.selectOne(namespace + "select", classCode);
    }

    @Override
    public int insert(ClassEnrollDto dto) throws Exception{
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public int update(ClassEnrollDto dto) throws Exception{
        return session.update(namespace + "update", dto);
    }

    @Override
    public int delete(Integer classCode)throws Exception{
        return session.delete(namespace + "delete", classCode);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public List<ClassEnrollDto> selectBoot(Integer courseCode) throws Exception {
        return session.selectList(namespace + "selectBoot", courseCode);
    }
}
