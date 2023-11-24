package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AllqnaCmmtDaoImpl implements AllqnaCmmtDao {
@Autowired
 private SqlSession session;
 private static String namespace = "com.jscd.app.board.qna.allqnacmmtMapper.";

//        @Override
//        public int count(Integer bno) throws Exception {
//            return session.selectOne(namespace+"count", bno);
//        } // T selectOne(String statement)
//
//        @Override
//        public int deleteAll(Integer bno) {
//            return session.delete(namespace+"deleteAll", bno);
//        } // int delete(String statement)
//
        @Override
        public int delete(int allqnaCNo) throws Exception {
//            Map map = new HashMap();
//            map.put("allqnaCNo", allqnaCNo);
//            map.put("writer", writer);
            return session.delete(namespace+"delete", allqnaCNo);
        }

        @Override
        public int insert(AllqnacDto allqnacDto) throws Exception {
            return session.insert(namespace+"insert", allqnacDto);
        }

        @Override
        public List<AllqnacDto> selectAll(Integer allqnaNo) throws Exception {
            return session.selectList(namespace+"selectAll", allqnaNo);
        }


        @Override
        public AllqnacDto select(Integer allqnaCNo) throws Exception {

            return session.selectOne(namespace + "select", allqnaCNo);
        } // T selectOne(String statement, Object parameter)

        @Override
         public int update(AllqnaDto allqnaDto) throws Exception {
         return 0;
        }

        @Override
        public int update(AllqnacDto allqnacDto) throws Exception {
            return session.update(namespace+"update", allqnacDto);
        }
    }

