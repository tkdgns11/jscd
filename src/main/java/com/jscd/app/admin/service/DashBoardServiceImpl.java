package com.jscd.app.admin.service;

import com.jscd.app.admin.dao.DailySummaryDao;
import com.jscd.app.admin.dto.DailySummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private DailySummaryDao dailySummaryDao;

    //대시보드 초기 메인페이지 보여줄 데이터 조회
    @Override
    public List<DailySummaryDto> initViewData() {
        return dailySummaryDao.selectDailySummary();
    }

    // 최근 7일 데이터 조회
    @Override
    public Map<String, Object> getWeekData() {
        return dailySummaryDao.selectWeekData();
    }

    // 이번달 데이터 조회
    @Override
    public Map<String, Object> getMonthData() {
        return dailySummaryDao.selectMonthData();
    }
}