package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AllqnaDaoImpl implements AllqnaDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.board.qna.allqnaMapper.";

    public int insert(AllqnaDto allqnaDto) throws Exception {
        System.out.println("Dao값 : " + allqnaDto);
        return session.insert(namespace + "insert", allqnaDto);
    }
    @Override
    public List<AllqnaDto> selectAll() throws Exception {
            return session.selectList(namespace+"selectAll");

    }

    public AllqnaDto select(Integer allqnaNo) throws Exception {
        return session.selectOne(namespace + "select", allqnaNo);
    }

    @Override
    public int increaseViewCnt(Integer allqnaNo) throws Exception {
        return session.update(namespace+"increaseViewCnt", allqnaNo);
    }


    @Override
    public int update(AllqnaDto allqnaDto) throws Exception {
        System.out.println("Dao : 수정하기 전"+allqnaDto); //여기까지는 값 온다
        System.out.println("DB에 들어갔는지 확인 : "+ session.update(namespace+"update", allqnaDto));
        return session.update(namespace+"update", allqnaDto);
    }

    @Override
    public int delete(Integer allqnaNo) throws Exception {
        return session.delete(namespace+"delete", allqnaNo);
    }

    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<AllqnaDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
}
