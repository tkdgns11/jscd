package com.jscd.app.board.notice.service;


import com.jscd.app.board.notice.dao.stdNoticeDao;
import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.stdNoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class stdNoticeServiceImpl implements stdNoticeService{
    @Autowired
    stdNoticeDao stdNoticeDao;

    @Override
    public List<stdNoticeDto> getSearchResultPage(SearchCon sc) throws Exception{
        return stdNoticeDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCon sc) throws Exception{
        return stdNoticeDao.searchResultcnt(sc);
    }

    @Override
    public int getCount() throws Exception {
        return stdNoticeDao.count();
    }

    @Override
    public int remove(Integer bno, String writer) throws Exception {
        return stdNoticeDao.delete(bno, writer);
    }


    @Override
    public int write(stdNoticeDto stdNoticeDto) throws Exception {
//        throw new Exception("test");
        return stdNoticeDao.insert(stdNoticeDto);
    }

    @Override
    public List<stdNoticeDto> getList() throws Exception {
        return stdNoticeDao.selectAll();
    }

    @Override
    public stdNoticeDto read(Integer bno) throws Exception {
        stdNoticeDto stdNoticeDto = stdNoticeDao.select(bno);
        stdNoticeDao.increaseViewCnt(bno);

        return stdNoticeDto;
    }

    @Override
    public List<stdNoticeDto> getPage(Map map) throws Exception {
        return stdNoticeDao.selectPage(map);
    }

    @Override
    public int modify(stdNoticeDto stdNoticeDto) throws Exception {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(date);
        stdNoticeDto.setModifyDate(today);
        int result = stdNoticeDao.update(stdNoticeDto);
        return result;
    }


}