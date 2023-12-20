package com.jscd.app.lecture.lstRegist.dao;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.dto.lstregistfileDto;
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

    //1.강의 목록
    @Override
    public List<LstRegistDto> getRegistList() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
    //2.강의 등록
    @Override
    public int addRegist(LstRegistDto lstRegistDto) throws Exception {
        return session.insert(namespace + "insert", lstRegistDto);
    }
    //3.강의 상세
    @Override
    public Map<String, Object> readRegist(Integer registCode) throws Exception {
        return session.selectOne(namespace + "select", registCode);
    }
    //4.강의 삭제
    @Override
    public int removeAllRegist(Integer registCode) throws Exception {
        return session.delete(namespace + "deleteAll", registCode);
    }
    //5.강의 수정
    @Override
    public int modifyRegist(LstRegistDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }


    //6.강의 카운트

    @Override
    public int countRegist() throws Exception {
        return session.selectOne(namespace + "count");
    }
    //7.강의 전체 삭제
    @Override
    public int removeRegist(Integer registCode) throws Exception {
        return session.delete(namespace + "delete", registCode);
    }

    //8.검색 및 페이지
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public List<LstRegistDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    }

    //9.세미나
    @Override
    public List<lstregistfileDto> getSeminarList() throws Exception {
        return session.selectList(namespace + "seminarList");
    }

    @Override
    public LstRegistDto readSeminar(Integer registCode) throws Exception {
        return session.selectOne(namespace + "seminarDetail", registCode);
    }

    //10.부트캠프
    @Override
    public List<LstRegistDto> getBootCampList() throws Exception {
        return session.selectList(namespace + "bootCampList");
    }

    //부트캠프 세부항목 읽기
    @Override
    public LstRegistDto readBootCamp(Integer registCode) throws Exception {
        return session.selectOne(namespace + "bootCampDetail", registCode);
    }

    //강의 첨부 파일
    @Override
    public int InsertFile(Map<String, Object> map) throws Exception {
        return session.insert(namespace+"InsertFile", map);
    }
    //강의 첨부 파일 조회
    @Override
    public List<Map<String, Object>> selectFileList(Integer registCode) throws Exception {
        return session.selectList(namespace+"selectFileList",registCode);
    }

    @Override
    public Map<String, Object> selectFileDown(Map<String, Object> map) throws Exception {
        return session.selectOne(namespace+"selectFileDown", map);
    }
    //강의 첨부 파일 수정
    @Override
    public void updateFile(Map<String, Object> map) throws Exception {
        session.update(namespace+"updateFile", map);
    }

    @Override
    public List<LstRegistDto> homeSeminarList() throws Exception {
        return session.selectList(namespace + "homeSeminarList");
    }

    @Override
    public List<LstRegistDto> homeBootCampList() throws Exception {
        return session.selectList(namespace + "homeBootCampList");
    }
}
