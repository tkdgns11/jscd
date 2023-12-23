package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.dto.lstregistfileDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

public interface LstService {
    //1.강의 목록
    List<LstRegistDto> getLstRegistList() throws Exception;
    //2.강의 등록
    void addRegist(LstRegistDto lstRegistDto,  MultipartHttpServletRequest mpRequest) throws Exception;
    //3.강의 상세
    Map<String, Object> readRegist(Integer registCode) throws Exception;
    //4.강의 삭제
    int removeRegist(Integer registCode) throws Exception;
    //5.강의 수정
    public void modifyRegist(LstRegistDto lstRegistDto, String[] files, String[] fileName, MultipartHttpServletRequest mpRequest) throws Exception;
    //6. 검색 및 페이지 처리
    int getSearchResultCnt(SearchCondition sc) throws Exception;
    List<LstRegistDto> getSearchResultPage(SearchCondition sc) throws Exception;

    //세미나 리스트 불러오기
    List<lstregistfileDto> seminarList() throws Exception;
    //세미나 세부항목 불러오기
    LstRegistDto seminarRead(Integer registCode) throws Exception;
    //(회원) 세미나 리스트 페이징
    List<lstregistfileDto> seminarPaging(Map map) throws Exception;

    //부트캠프 리스트 불러오기
    List<LstRegistDto> bootCampList() throws Exception;
    //부트캠프 세부항목 불러오기
    LstRegistDto bootCampRead(Integer registCode) throws Exception;
    //(회원) 부트캠프 리스트 페이징
    List<LstRegistDto> bootCampPaging(Map map) throws Exception;
    //(회원) 부트캠프 진행예정 페이징
    List<LstRegistDto> appointBTList(Map map) throws Exception;

    // 첨부파일 조회
    public List<Map<String, Object>> selectFileList(Integer registCode) throws Exception;
    //첨부파일 다운로드
    public Map<String, Object> selectFileDown(Map<String, Object> map) throws Exception;

    int getCountAll() throws Exception;

    int getCountBT() throws Exception;

    int getCountSM() throws Exception;

    // 홈 화면 세미나 리스트
    List<LstRegistDto> homeSeminarList() throws Exception;
    // 홈 화면 부트캠프 리스트
    List<LstRegistDto> homeBootCampList() throws Exception;


    void lstRegistInprocess() throws Exception;
}
