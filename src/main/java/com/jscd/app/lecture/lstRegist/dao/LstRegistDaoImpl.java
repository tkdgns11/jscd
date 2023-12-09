package com.jscd.app.lecture.lstRegist.dao;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LstRegistDaoImpl implements LstRegistDao {
    @Autowired
    SqlSession session;
    private String namespace = "com.jscd.app.lecture.lstRegist.lstRegistMapper.";

    @Override
    public int countRegist() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int addRegist(LstRegistDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public List<LstRegistDto> getRegistList() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public Map<String, Object> readRegist(Integer registCode) throws Exception {
        return session.selectOne(namespace + "select", registCode);
    }

    @Override
    public int modifyRegist(LstRegistDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    @Override
    public int removeAllRegist(Integer registCode) throws Exception {
        return session.delete(namespace + "deleteAll", registCode);
    }

    @Override
    public int removeRegist(Integer registCode) throws Exception {
        return session.delete(namespace + "delete", registCode);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public List<LstRegistDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    }

    @Override
    public List<LstRegistDto> getSeminarList() throws Exception {
        return session.selectList(namespace + "seminarList");
    }

    @Override
    public LstRegistDto readSeminar(Integer registCode) throws Exception {
        return session.selectOne(namespace + "seminarDetail", registCode);
    }

    @Override
    public List<LstRegistDto> getBootCampList() throws Exception {
        return session.selectList(namespace + "bootCampList");
    }

    @Override
    public LstRegistDto readBootCamp(Integer registCode) throws Exception {
        return session.selectOne(namespace + "bootCampDetail", registCode);
    }
}
