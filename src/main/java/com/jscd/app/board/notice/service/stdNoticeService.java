package com.jscd.app.board.notice.service;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.stdNoticeDto;

import java.util.List;
import java.util.Map;

public interface stdNoticeService {
    List<stdNoticeDto> getSearchResultPage(SearchCon sc) throws Exception;

    int getSearchResultCnt(SearchCon sc) throws Exception;

    int getCount() throws Exception;

    int remove(Integer bno, String writer) throws Exception;

    int write(stdNoticeDto stdNoticeDto) throws Exception;

    List<stdNoticeDto> getList() throws Exception;

    stdNoticeDto read(Integer bno) throws Exception;

    List<stdNoticeDto> getPage(Map map) throws Exception;

    int modify(stdNoticeDto stdNoticeDto) throws Exception;
}
