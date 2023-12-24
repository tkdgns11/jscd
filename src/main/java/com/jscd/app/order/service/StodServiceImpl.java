package com.jscd.app.order.service;

import com.jscd.app.admin.dao.DailySummaryDao;
import com.jscd.app.order.dao.StodDao;
import com.jscd.app.order.dto.StodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StodServiceImpl implements StodService {

    private final StodDao stodDao;

    @Autowired
    DailySummaryDao dailySummaryDao;

    public StodServiceImpl(StodDao stodDao) {
        this.stodDao = stodDao;
    }

    // 주문 내역 테이블에 데이터 저장
    @Override
    public int insertStod(StodDTO stodDTO) throws Exception {
        int result = stodDao.insertStod(stodDTO);
        if (result != 1) {
            throw new Exception("insertStod failed");
        }
        return result;
    }

    // lectureApply.status == 'paid' update
    @Override
    public void updateStatusToPaid(String id, int registCode) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("registCode", registCode);

        int result = stodDao.updateStatusToPaid(params);
        if (result != 1) {
            throw new Exception("updateStatusToPaid failed");
        }
    }

    // 결제내역 테이블에 데이터 저장
    @Override
    public int insertPayHty(StodDTO stodDTO) throws Exception {
        int result = stodDao.insertPayHty(stodDTO);
        if (result != 1) {
            throw new Exception("insertPayHty failed");
        }

        Map map = new HashMap();
        map.put("lastPrice", stodDTO.getLastPrice());
        dailySummaryDao.updateRevenue(map);

        return result;
    }

    // 주문 내역 조회
    // StodDao의 selectOrderList() 호출, '주문 내역' 조회 및 결과 반환
    // OrderController.java에서 selectOrderList() 호출 시 '주문 내역' 조회 가능
    @Override
    public List<StodDTO> selectOrderList(String id, int page, int itemsPerPage) throws Exception {
        int start = (page - 1) * itemsPerPage;
        int end = itemsPerPage; // #{end} : 시작점으로부터 가져올 레코드의 개수 (OrderController.java - getOrderList()와 연결 됨)
        return stodDao.selectOrderList(id, start, end);
    }


    // 전체 아이템 수 조회
    @Override
    public int countOrderList(String id) throws Exception {
        return stodDao.countOrderList(id);
    }

    // 주문 상세 내역 조회
    @Override
    public List<StodDTO> selectOrderDetail(String id, String odNo) throws Exception {
        return stodDao.selectOrderDetail(id, odNo);
    }
}
