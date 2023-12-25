package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.DailySummaryDto;

import java.util.List;
import java.util.Map;

public interface DailySummaryDao {

    int insert(DailySummaryDto dto) throws Exception;

    Map<String, Object> selectWeekData();

    Map<String, Object> selectMonthData();

    //매출액 추가
    int updateRevenue(Map map) throws Exception;

    List<DailySummaryDto> selectDailySummary();
}