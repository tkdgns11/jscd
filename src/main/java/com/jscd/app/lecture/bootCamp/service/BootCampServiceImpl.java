package com.jscd.app.lecture.bootCamp.service;

import com.jscd.app.lecture.bootCamp.dao.BootCampDao;
import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BootCampServiceImpl implements BootCampService {
    @Autowired
    BootCampDao bootCampDao;

    @Override
    public int getCount() throws Exception{
        return bootCampDao.count();
    }

    @Override
    public int remove(Integer classEnrollNo, String writer) throws Exception{
        return bootCampDao.delete(classEnrollNo, writer);
    }

    @Override
    public int write(BootCampDto dto) throws Exception {
        return bootCampDao.insert(dto);
    }

    @Override
    public List<BootCampDto> getList() throws Exception{
        return bootCampDao.selectAll();
    }

    @Override
    public BootCampDto read(Integer classEnrollNo) throws Exception{
        BootCampDto bootCampDto = bootCampDao.select(classEnrollNo);
        bootCampDao.increaseViewCnt(classEnrollNo);
        return bootCampDto;
    }

    @Override
    public List<BootCampDto> getPage(Map map) throws Exception{
        return bootCampDao.selectPage(map);
    }

    @Override
    public int modify(BootCampDto dto) throws Exception{
        return bootCampDao.update(dto);
    }
}
