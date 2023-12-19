package com.jscd.app.lecture.lstRegist.dao;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.dto.lstregistfileDto;

import java.util.List;
import java.util.Map;

public interface LstRegistDao {

    //1.강의 목록
    List<LstRegistDto> getRegistList() throws Exception;
    //2.강의 등록
    int addRegist(LstRegistDto dto) throws Exception;
    //3.강의 상세
    Map<String, Object> readRegist(Integer registCode) throws Exception;
    //4.강의 삭제
    int removeRegist(Integer registCode) throws Exception;
    //5.강의 수정
    int modifyRegist(LstRegistDto dto) throws Exception;
    //6.강의 개수
    int countRegist() throws Exception;
    //7.강의 전체 삭제
    int removeAllRegist(Integer registCode) throws Exception;

    //8.검색 및 페이지
    int searchResultCnt(SearchCondition sc) throws Exception;
    List<LstRegistDto> searchSelectPage(SearchCondition sc) throws Exception;

    //9.세미나
    //9.1 세미나 목록 불러오기
    List<lstregistfileDto> getSeminarList() throws Exception;
    // 9.2 세미나 세부사항 확인하기
    LstRegistDto readSeminar(Integer registCode) throws Exception;

    //10.부트캠프
    List<LstRegistDto> getBootCampList() throws Exception;
    LstRegistDto readBootCamp(Integer registCode) throws Exception;

    // 첨부파일 업로드
    public int InsertFile(Map<String, Object> map) throws Exception;
    // 첨부파일 조회
    public List<Map<String, Object>> selectFileList(Integer registCode) throws Exception;
    // 첨부파일 다운로드
    public Map<String, Object> selectFileDown(Map<String, Object> map) throws Exception;
    // 첨부파일 수정
    public void updateFile(Map<String, Object> map) throws Exception;

}
