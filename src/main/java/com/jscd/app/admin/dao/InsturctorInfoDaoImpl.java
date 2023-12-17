package com.jscd.app.admin.dao;


import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InsturctorInfoDaoImpl implements InsturctorInfoDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.jscd.app.mapper.instructorInfoMapper.";

    @Override
    public int insert(InstructorInfoDto instructorInfoDto) throws Exception {
        return session.insert(namespace + "insert", instructorInfoDto);
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public List<InstructorMemberInfoDto> selectAll(int offset, int pageSize) throws Exception {
        Map map = new HashMap();
        map.put("offset", offset);
        map.put("pageSize", pageSize);

        return session.selectList(namespace + "selectAll", map);
    }

    @Override
    public InstructorMemberInfoDto select(Integer mebrNo) throws Exception {
        return session.selectOne(namespace + "select", mebrNo);
    }

    @Override
    public int update(InstructorInfoDto instructorInfoDto) throws Exception {
        return session.update(namespace + "update", instructorInfoDto);
    }

    @Override
    public int updateStatus(Integer status, List<Integer> mebrNo) throws Exception {
        Map map = new HashMap();
        map.put("status",status);
        map.put("mebrNo",mebrNo);
        return session.update(namespace + "updateStatus", map);
    }

    @Override
    public int delete(Integer mebrNo) throws Exception {
        return session.delete(namespace + "delete", mebrNo);
    }

    @Override
    public void deleteAll() throws Exception {
        session.delete(namespace + "deleteAll");
    }

    @Override
    public List<InstructorMemberInfoDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
    @Override
    public int updateIntro(InstructorInfoDto instructorInfoDto)throws Exception{
        return session.update(namespace+"updateIntro",instructorInfoDto);
    }


}
