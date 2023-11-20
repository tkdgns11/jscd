package com.jscd.app.admin.dao;


import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InsturctorInfoDaoImpl implements InsturctorInfoDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.jscd.app.mapper.instructorInfoMapper.";

    @Override
    public int insert(InstructorInfoDto instructorInfoDto)throws Exception{
        return session.insert(namespace+"insert",instructorInfoDto);
    }
    @Override
    public int count()throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<InstructorMemberInfoDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public InstructorMemberInfoDto select(String iscrNo)throws Exception{
        return session.selectOne(namespace+"select",iscrNo);
    }

    @Override
    public int update(InstructorInfoDto instructorInfoDto)throws Exception{
        return session.update(namespace+"update",instructorInfoDto);
    }

    @Override
    public int delete(Integer mebrNo)throws Exception{
        return session.delete(namespace+"delete",mebrNo);
    }

    @Override
    public void deleteAll()throws Exception{
        session.delete(namespace+"deleteAll");
    }



}
