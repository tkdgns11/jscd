package com.jscd.app.board.notice.service;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.noticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeService {

        List<noticeDto> getSearchResultPage(SearchCon sc) throws Exception;

        int getSearchResultCnt(SearchCon sc) throws Exception;

        int getCount() throws Exception;

        int remove(Integer bno, String writer) throws Exception;

        int write(noticeDto noticeDto) throws Exception;

        List<noticeDto> getList() throws Exception;

        noticeDto read(Integer bno) throws Exception;

        List<noticeDto> getPage(Map map) throws Exception;

        int modify(noticeDto noticeDto) throws Exception;
}
