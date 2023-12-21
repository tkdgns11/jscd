package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;
import com.jscd.app.applyTraining.dto.SmApplicationDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SmApplicationDaoImpl implements SmApplicationDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.applyTraining.smApplicationMapper.";

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace + "count");
    }

    //결제대기
    @Override
    public int countWaitPay() throws Exception {
        System.out.println("session.selectOne(namespace + \"countWaitPay\") = " + session.selectOne(namespace + "countWaitPay"));
        return session.selectOne(namespace + "countWaitPay");
    }

    //등록완료
    @Override
    public int countRegist() throws Exception {
        return session.selectOne(namespace + "countRegist");
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
    public List<SmApplicationDto> selectAll() throws Exception{
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public SmApplicationDto select(Integer stfmNo) throws Exception{
        return session.selectOne(namespace + "select", stfmNo);
    }

    @Override
    public List<SmApplicationDto> selectPage(Map map) throws Exception{
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public int update(SmApplicationDto dto) throws Exception{
        return session.update(namespace + "update", dto);
    }

    @Override
    public int insert(SmApplicationDto dto) throws Exception{
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public int lectureApplyInsert(SmApplicationDto dto) throws Exception{
        return session.insert(namespace + "lectureApplyInsert", dto);
    }

    @Override
    public int confirmApplcation(SmApplicationDto dto) throws Exception{
        return session.selectOne(namespace + "confirmApplication", dto);
    }

    @Override
    public List<SmApplicationDto> searchSelectPage(SearchApplication sa) throws Exception{
        return session.selectList(namespace + "searchSelectPage", sa);
    }

    @Override
    public int searchResultCnt(SearchApplication sa) throws Exception{
        return session.selectOne(namespace + "searchResultCnt", sa);
    }
}
