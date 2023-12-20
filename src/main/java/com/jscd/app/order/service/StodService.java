package com.jscd.app.order.service;

import com.jscd.app.order.dto.StodDTO;

import java.util.List;

public interface StodService {
    //주문 이력 테이블에 데이터 저장
    public int insertStod(StodDTO stodDTO) throws Exception;

    //결제 이력 테이블에 데이터 저장
    public int insertPayHty(StodDTO stodDTO) throws Exception;
    
    // '주문 내역' 데이터 조회
//    public List<StodDTO> selectOrderList(String id) throws Exception;
    List<StodDTO> selectOrderList(String id, int page, int itemsPerPage) throws Exception;

    int countOrderList(String id) throws Exception;
    
    // 주문 상세 내역 조회
    List<StodDTO> selectOrderDetail(String id, String odNo) throws Exception;
}
