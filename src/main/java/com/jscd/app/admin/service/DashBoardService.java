package com.jscd.app.admin.service;

import com.jscd.app.admin.dto.DailySummaryDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface DashBoardService {

    List<DailySummaryDto> initViewData();

    // 최근 7일 데이터 조회
    Map<String, Object> getWeekData();

    // 이번달 데이터 조회
    Map<String, Object> getMonthData();
}
