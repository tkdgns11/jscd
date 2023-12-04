package com.jscd.app.admin.dao;

import com.jscd.app.admin.domain.SearchCondition;
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
    public int insert(StdManageDto stdManageDto) throws Exception {
        return session.insert(namespace + "insert", stdManageDto);
    }

    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public List<StdMemberManageDto> selectAll(int offset, int pageSize) throws Exception {
        Map map = new HashMap();
        map.put("offset", offset);
        map.put("pageSize", pageSize);
        return session.selectList(namespace + "selectAll", map);
    }

    @Override
    public StdMemberManageDto select(Integer mebrNo) throws Exception {
        return session.selectOne(namespace + "select", mebrNo);
    }

    @Override
    public int update(StdManageDto stdManageDto) throws Exception {
        return session.update(namespace + "update", stdManageDto);
    }

    @Override
    public int updateStatus(Integer status, List<Integer> mebrNo) throws Exception {
        Map map = new HashMap();
        map.put("status",status);
        map.put("mebrNo",mebrNo);
        return session.update(namespace + "updateStatus", map);
    }

    @Override
    public int deleteMain(List<Integer> mebrNo) throws Exception {
        return session.delete(namespace + "deleteMain",mebrNo);
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
    public List<StdMemberManageDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }

}
