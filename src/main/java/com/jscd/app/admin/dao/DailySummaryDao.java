package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.DailySummaryDto;
import com.jscd.app.facility.dto.LockerDto;

import java.util.List;
import java.util.Map;

public interface DailySummaryDao {

    int insert(DailySummaryDto dto) throws Exception;

    Map<String, Object> selectWeekData();

    Map<String, Object> selectMonthData();

    List<DailySummaryDto> selectDailySummary();
}