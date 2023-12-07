package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dao.LstRegistDao;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LstServiceImpl implements LstService {
    @Autowired
    LstRegistDao lstRegistDao;
    @Override
    public List<LstRegistDto> getLstRegistList() throws Exception {
        return lstRegistDao.getRegistList();
    }

    @Override
    public int addRegist(LstRegistDto dto) throws Exception {
        return lstRegistDao.addRegist(dto);
    }

    @Override
    public Map<String, Object> readRegist(Integer registCode) throws Exception {
        return lstRegistDao.readRegist(registCode);
    }

    @Override
    public int removeRegist(Integer registCode) throws Exception {
        return lstRegistDao.removeRegist(registCode);
    }

    @Override
    public int modifyRegist(LstRegistDto dto) throws Exception {
        return lstRegistDao.modifyRegist(dto);
    }
}
