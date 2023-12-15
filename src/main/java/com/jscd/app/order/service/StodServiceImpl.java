package com.jscd.app.order.service;

import com.jscd.app.order.dao.StodDao;
import com.jscd.app.order.dto.StodDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StodServiceImpl implements StodService {

    private final StodDao stodDao;

    public StodServiceImpl(StodDao stodDao) {
        this.stodDao = stodDao;
    }

    @Override
    public int insertStod(StodDTO stodDTO) throws Exception {
        return stodDao.insertStod(stodDTO);
    }

    @Override
    public int insertPayHty(StodDTO stodDTO) throws Exception {
        return stodDao.insertPayHty(stodDTO);
    }

    // 주문 내역 조회
    // StodDao의 selectOrderList() 호출, '주문 내역' 조회 및 결과 반환
    // OrderController.java에서 selectOrderList() 호출 시 '주문 내역' 조회 가능
    @Override
    public List<StodDTO> selectOrderList(String id) throws Exception {
        return stodDao.selectOrderList(id);
    }
    
    // 주문 상세 내역 조회
    @Override
    public List<StodDTO> selectOrderDetail(String id, String odNo) throws Exception {
        return stodDao.selectOrderDetail(id, odNo);
    }
}
