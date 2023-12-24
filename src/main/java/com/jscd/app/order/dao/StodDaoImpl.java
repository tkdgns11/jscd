package com.jscd.app.order.dao;

import com.jscd.app.order.dto.StodDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StodDaoImpl implements StodDao {
    private final SqlSession sqlSession;

    private static String namespace = "com.jscd.app.order.StodMapper.";

    @Autowired
    public StodDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public int insertStod(StodDTO stodDTO) throws Exception {
        return sqlSession.insert(namespace + "insertStod", stodDTO);
    }

    @Override
    public int insertPayHty(StodDTO stodDTO) throws Exception {
        return sqlSession.insert(namespace + "insertPayHty", stodDTO);
    }

    // lectureApply.status == 'paid' update
    @Override
    public int updateStatusToPaid(Map<String, Object> params) {
        return sqlSession.update("updateStatusToPaid", params);
    }

    // '주문 내역 조회'
    // 1. MyBatis의 selectList() 사용 -> selectOrderList 쿼리 실행
    // 2. 결과 -> List<StodDTO> 형태로 반환
    // 3. selectList() : 매개변수로 받은 memberId를  selectOrderList 쿼리에 바인딩
    @Override
    public List<StodDTO> selectOrderList(String id, int start, int end) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("start", start);
        params.put("end", end);
        return sqlSession.selectList("selectOrderList", params);
    }

    @Override
    public int countOrderList(String id) throws Exception {
        return sqlSession.selectOne("countOrderList", id);
    }



    // '주문 상세 내역 조회'
    // 1. 결과 여러 개 반환 가능 -> 반환 타입 지정 : List<StodDTO>
    @Override
    public List<StodDTO> selectOrderDetail(String id, String odNo) throws Exception {
        // 2. Map에 id, odNo 파라미터 넣어 MyBatis에 전달
        // 3. MyBatis -> Map의 키를 파라미터 이름으로 인식하여 SQL 쿼리 실행
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("odNo", odNo);
        return sqlSession.selectList("selectOrderDetail", params);
    }
}