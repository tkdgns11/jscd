package com.jscd.app.lecture.seminar.service;

import com.jscd.app.lecture.seminar.dao.SeminarRegistDao;
import com.jscd.app.lecture.seminar.domain.SeminarRegistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeminarRegistServiceImpl implements SeminarRegistService {
    @Autowired
    SeminarRegistDao seminarRegistDao;

    @Override
    public int getCount() throws Exception{
        return seminarRegistDao.count();
    }

    @Override
    public int remove(Integer classEnrollNo, String writer) throws Exception{
        return seminarRegistDao.delete(classEnrollNo, writer);
    }

    @Override
    public int write(SeminarRegistDto dto) throws Exception {
        return seminarRegistDao.insert(dto);
    }

    @Override
    public List<SeminarRegistDto> getList() throws Exception{
        return seminarRegistDao.selectAll();
    }

    @Override
    public SeminarRegistDto read(Integer classEnrollNo) throws Exception{
        SeminarRegistDto seminarRegistDto = seminarRegistDao.select(classEnrollNo);
        seminarRegistDao.increaseViewCnt(classEnrollNo);
        return seminarRegistDto;
    }

    @Override
    public List<SeminarRegistDto> getPage(Map map) throws Exception{
        return seminarRegistDao.selectPage(map);
    }

    @Override
    public int modify(SeminarRegistDto dto) throws Exception{
        return seminarRegistDao.update(dto);
    }
}
