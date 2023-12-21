package com.jscd.app.applyTraining.service;

import com.jscd.app.applyTraining.dao.SmApplicationDao;
import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;
import com.jscd.app.applyTraining.dto.SmApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SmApplicationServiceImpl implements SmApplicationService {
    @Autowired
    SmApplicationDao smApplicationDao;

    @Override
    public int getCount() throws Exception {
        return smApplicationDao.count();
    }

    @Override
    public int getWaitPayNum() throws Exception {
        return smApplicationDao.countWaitPay();
    }

    @Override
    public int getRegistNum() throws Exception {
        return smApplicationDao.countRegist();
    }

    @Override
    public int remove(Integer stfmNo) throws Exception{
        return smApplicationDao.delete(stfmNo);
    }

    @Override
    public List<SmApplicationDto> getList() throws Exception{
        return smApplicationDao.selectAll();
    }

    @Override
    public SmApplicationDto read(Integer stfmNo) throws Exception{
        return smApplicationDao.select(stfmNo);
    }

    @Override
    public List<SmApplicationDto> getPage(Map map) throws Exception{
        return smApplicationDao.selectPage(map);
    }

    @Override
    public int modify(SmApplicationDto dto) throws Exception{
        return smApplicationDao.update(dto);
    }

    @Override
    public int write(SmApplicationDto dto) throws Exception{
        return smApplicationDao.insert(dto);
    }

    @Override
    public int lectureApplyInsert(SmApplicationDto dto) throws Exception{
        return smApplicationDao.lectureApplyInsert(dto);
    }

    @Override
    public int confirmApplcation(SmApplicationDto dto) throws Exception{
        return smApplicationDao.confirmApplcation(dto);
    }
    @Override
    public List<SmApplicationDto> getSearchResultpage(SearchApplication sa) throws Exception{
        return smApplicationDao.searchSelectPage(sa);
    }

    @Override
    public int getSearchResulCnt(SearchApplication sa) throws Exception{
        return smApplicationDao.searchResultCnt(sa);
    }
}
