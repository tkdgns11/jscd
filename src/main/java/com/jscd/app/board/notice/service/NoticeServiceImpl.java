package com.jscd.app.board.notice.service;


import com.jscd.app.board.notice.dao.noticeDao;
import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.noticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    noticeDao noticeDao;

    @Override
    public List<noticeDto> getSearchResultPage(SearchCon sc) throws Exception {
        return noticeDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCon sc) throws Exception {
        return noticeDao.searchResultcnt(sc);
    }

    @Override
    public int getCount() throws Exception {
        return noticeDao.count();
    }

    @Override
    public int remove(Integer bno, String writer) throws Exception {
        return noticeDao.delete(bno, writer);
    }


    @Override
    public int write(noticeDto noticeDto) throws Exception {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        noticeDto.setModifyDate(today);
        int result = noticeDao.insert(noticeDto);
        return result;
//        return noticeDao.insert(noticeDto);
    }

    @Override
    public List<noticeDto> getList() throws Exception {
        return noticeDao.selectAll();
    }

    @Override
    public noticeDto read(Integer bno) throws Exception {
        noticeDto noticeDto = noticeDao.select(bno);
        noticeDao.increaseViewCnt(bno);

        return noticeDto;
    }

    @Override
    public List<noticeDto> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }

    @Override
    public int modify(noticeDto noticeDto) throws Exception {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(date);
        noticeDto.setModifyDate(today);
        int result = noticeDao.update(noticeDto);
        return result;


    }

}