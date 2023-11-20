package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StdManageDaoImpl implements StdManageDao {

    @Autowired
    SqlSession session;
    private static String namespace = "com.jscd.app.mapper.stdManageMapper.";

    @Override
    public int insert(StdManageDto stdManageDto)throws Exception{
        return session.insert(namespace+"insert",stdManageDto);
    }

    public int count()throws Exception{
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<StdMemberManageDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public StdMemberManageDto select(Integer mebrNo)throws Exception{
        return session.selectOne(namespace+"select",mebrNo);
    }

    @Override
    public int update(StdManageDto stdManageDto)throws Exception{
        return session.update(namespace+"update",stdManageDto);
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
