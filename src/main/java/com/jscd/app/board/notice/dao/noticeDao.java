package com.jscd.app.board.notice.dao;

import com.jscd.app.board.notice.dto.noticeDto;
import com.jscd.app.board.notice.dto.SearchCon;

import java.util.List;
import java.util.Map;


public interface noticeDao  {


    int count() throws Exception // T selectOne(String statement)
    ;

    int deleteAll() // int delete(String statement)
    ;

    int delete(Integer bno, String writer) throws Exception // int delete(String statement, Object parameter)
    ;

    int insert(noticeDto dto) throws Exception // int insert(String statement, Object parameter)
    ;

    List<noticeDto> selectAll() throws Exception // List<E> selectList(String statement)
    ;

    noticeDto select(Integer bno) throws Exception // T selectOne(String statement, Object parameter)
    ;

    List<noticeDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;

    int update(noticeDto dto) throws Exception // int update(String statement, Object parameter)
    ;

    int increaseViewCnt(Integer bno) throws Exception // int update(String statement, Object parameter)
    ;
    List<noticeDto> searchSelectPage(SearchCon sc) throws Exception;
    int searchResultcnt(SearchCon sc) throws Exception;

}
