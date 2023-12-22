package com.jscd.app.applyTraining.service;

import com.jscd.app.applyTraining.dao.BtApplicationDao;
import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BtApplicationServiceImpl implements BtApplicationService {
    @Autowired
    BtApplicationDao btApplicationDao;

    @Override
    public int getCount() throws Exception {
        return btApplicationDao.count();
    }


    @Override
    public int getWaitingNum() throws Exception {
        return btApplicationDao.countWaiting();
    }

    @Override
    public int getApprovalNum() throws Exception {
        return btApplicationDao.countApproval();
    }

    @Override
    public int getNotApprovalNum() throws Exception {
        return btApplicationDao.countNotApproval();
    }

    @Override
    public int getWaitPayNum() throws Exception {
        return btApplicationDao.countWaitPay();
    }

    @Override
    public int getRegistNum() throws Exception {
        return btApplicationDao.countRegist();
    }

    @Override
    public int remove(Integer stfmNo) throws Exception{
        return btApplicationDao.delete(stfmNo);
    }

    @Override
    public List<BtApplicationDto> getList() throws Exception{
        return btApplicationDao.selectAll();
    }

    @Override
    public BtApplicationDto read(Integer stfmNo) throws Exception{
        return btApplicationDao.select(stfmNo);
    }

    @Override
    public List<BtApplicationDto> getPage(Map map) throws Exception{
        return btApplicationDao.selectPage(map);
    }

    @Override
    public int modify(BtApplicationDto dto) throws Exception{
        return btApplicationDao.update(dto);
    }

    // 부트캠프 폼 작성
    @Override
    public int write(BtApplicationDto dto) throws Exception{
        return btApplicationDao.insert(dto);
    }
//    부트캠프 폼 상태

    @Override
    public int lectureApplyInsert(BtApplicationDto dto) throws Exception{
        return btApplicationDao.lectureApplyInsert(dto);
    }

    @Override
    public int confirmApplcation(BtApplicationDto dto) throws Exception{
        return btApplicationDao.confirmApplcation(dto);
    }

    @Override
    public List<BtApplicationDto> getSearchResultpage(SearchApplication sa) throws Exception{
        return btApplicationDao.searchSelectPage(sa);
    }

    @Override
    public int getSearchResulCnt(SearchApplication sa) throws Exception{
        return btApplicationDao.searchResultCnt(sa);
    }

}
