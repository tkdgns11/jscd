package com.jscd.app.board.notice.dao;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.stdNoticeDto;

import java.util.List;
import java.util.Map;


public interface stdNoticeDao {


    int count() throws Exception // T selectOne(String statement)
    ;

    int deleteAll() // int delete(String statement)
    ;

    int delete(Integer bno, String writer) throws Exception // int delete(String statement, Object parameter)
    ;

    int insert(stdNoticeDto dto) throws Exception // int insert(String statement, Object parameter)
    ;

    List<stdNoticeDto> selectAll() throws Exception // List<E> selectList(String statement)
    ;

    stdNoticeDto select(Integer bno) throws Exception // T selectOne(String statement, Object parameter)
    ;

    List<stdNoticeDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;

    int update(stdNoticeDto dto) throws Exception // int update(String statement, Object parameter)
    ;

    int increaseViewCnt(Integer bno) throws Exception // int update(String statement, Object parameter)
    ;
    List<stdNoticeDto> searchSelectPage(SearchCon sc) throws Exception;
    int searchResultcnt(SearchCon sc) throws Exception;

}
