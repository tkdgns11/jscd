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
    public int registBootCamp(BootCampDto bootCampDto) throws Exception {
        return bootCampDao.insertBootCamp(bootCampDto);
    }

    @Override
    public List<BootCampDto> getList() throws Exception {
        return bootCampDao.selectAll();
    }

    @Override
    public List<BootCampDto> getPage(Map map) throws Exception {
        return bootCampDao.selectPage(map);
    }

    @Override
    public int getCount() throws Exception {
        return bootCampDao.count();
    }
}
