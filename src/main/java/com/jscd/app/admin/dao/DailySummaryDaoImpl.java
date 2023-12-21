package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.DailySummaryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DailySummaryDaoImpl implements DailySummaryDao {

    private final SqlSession sqlSession;

    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.mapper.DailySummaryMapper.";

    @Autowired
    public DailySummaryDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    //데이터 넣기
    @Override
    public int insert(DailySummaryDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }


    //최근 7일 전체 정보 조회
    @Override
    public List<DailySummaryDto> selectDailySummary() {
        return sqlSession.selectList(namespace + "selectRecentData");
    }


    //최근 7일 정보 조회
    @Override
    public Map<String, Object> selectWeekData() {
        return sqlSession.selectOne(namespace + "selectWeekData");
    }

    //이번달 정보 조회
    @Override
    public Map<String, Object> selectMonthData() {
        return sqlSession.selectOne(namespace + "selectMonthData");
    }


}