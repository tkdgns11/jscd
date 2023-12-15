package com.jscd.app.order.dao;

import com.jscd.app.order.dto.StodDTO;

import java.util.List;

public interface StodDao {
    //    결제 완료 시 데이터 삽입
    int insertStod(StodDTO stodDTO) throws Exception;

    int insertPayHty(StodDTO stodDTO) throws Exception;

    //    주문 내역 조회
    List<StodDTO> selectOrderList(String id) throws Exception;
    
    // 주문 상세 내역 조회
    // id, odNo 파라미터 반영
    List<StodDTO> selectOrderDetail(String id, String odNo) throws Exception;
}
