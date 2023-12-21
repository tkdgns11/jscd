package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;
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

    //승인대기중
    @Override
    public int countWaiting() throws Exception {
        return session.selectOne(namespace + "countWaiting");
    }

    //승인완료
    @Override
    public int countApproval() throws Exception {
        return session.selectOne(namespace + "countApproval");
    }

    //미승인
    @Override
    public int countNotApproval() throws Exception {
        return session.selectOne(namespace + "countNotApproval");
    }

    //결제대기
    @Override
    public int countWaitPay() throws Exception {
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
    public int lectureApplyInsert(BtApplicationDto dto) throws Exception{
        return session.insert(namespace + "lectureApplyInsert", dto);
    }

    @Override
    public int confirmApplcation(BtApplicationDto dto) throws Exception{
        return session.selectOne(namespace + "confirmApplication", dto);
    }

    @Override
    public List<BtApplicationDto> searchSelectPage(SearchApplication sa) throws Exception{
        return session.selectList(namespace + "searchSelectPage", sa);
    }

    @Override
    public int searchResultCnt(SearchApplication sa) throws Exception{
        return session.selectOne(namespace + "searchResultCnt", sa);
    }

}
