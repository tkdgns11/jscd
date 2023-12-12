package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dao.LstRegistDao;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
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

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return lstRegistDao.searchResultCnt(sc);
    }

    @Override
    public List<LstRegistDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return lstRegistDao.searchSelectPage(sc);
    }
    @Override
    public List<LstRegistDto> seminarList() throws Exception {
        return lstRegistDao.getSeminarList();
    }

    @Override
    public LstRegistDto seminarRead(Integer registCode) throws Exception {
        LstRegistDto lstRegistDto = lstRegistDao.readSeminar(registCode);
        return lstRegistDto;
    }

    @Override
    public List<LstRegistDto> bootCampList() throws Exception {
        return lstRegistDao.getBootCampList();
    }

    @Override
    public LstRegistDto bootCampRead(Integer registCode) throws Exception {
        LstRegistDto lstRegistDto = lstRegistDao.readBootCamp(registCode);
        return lstRegistDto;
    }
}
