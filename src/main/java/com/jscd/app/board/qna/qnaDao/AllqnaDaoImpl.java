package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import com.jscd.app.board.qna.qnaDto.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AllqnaDaoImpl implements AllqnaDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.jscd.app.board.qna.allqnaMapper.";
    //1-1. 게시글 등록
    public int insert(AllqnaDto allqnaDto) throws Exception {
        return session.insert(namespace+"insert", allqnaDto);
    } // int insert(String statement, Object parameter)

    //1-2. 게시글 목록 읽기

    @Override
    public List<AllqnaDto> selectList(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"selectAll", sc);
    }

    //1-3 게시글 1개 읽기
    public AllqnaDto select(Integer allqnaNo) throws Exception {
        return session.selectOne(namespace + "select", allqnaNo);
    }

    //1-4. 게시글 수정
    @Override
    public int update(AllqnaDto allqnaDto) throws Exception {
        return session.update(namespace+"update", allqnaDto);
    } // int update(String statement, Object parameter)

    //1-5. 게시글 삭제
    @Override
    public int delete(Integer allqnaNo, String writer) throws Exception {
        Map map = new HashMap();
        map.put("allqnaNo", allqnaNo);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    }


    //2-1 댓글 등록

    @Override
    public int cmmtInsert(AllqnacDto allqnacDto) throws Exception {
        return session.insert(namespace+"cmmtInsert", allqnacDto);
    }


    //2-2 댓글 목록
    @Override
    public List<AllqnacDto> selectAll(Integer allqnaNo) throws Exception {
        return session.selectList(namespace+"cmmtSelectAll", allqnaNo);
    }

    //2-3 댓글 수정
    @Override
    public int cmmtUpdate(AllqnacDto allqnacDto) throws Exception {
        System.out.println("다오 댓글수정 : " +allqnacDto);
        return session.update(namespace+"cmmtUpdate", allqnacDto);
    }

    //2-4 댓글 삭제
    @Override
    public int cmmtDelete(Integer allqnaCNo) throws Exception {
//        Map map = new HashMap();
//        map.put("allqnaCNo", allqnaCNo);
        System.out.println("댓글수정 디비 : "+session.delete(namespace+"cmmtDelete", allqnaCNo));

        return 0;
    }

    //3-1 대댓글 등록
    //3-2 대댓글 목록
    //3-3 대댓글 수정
    //3-4 대댓글 삭제

    //4 비밀글 제외
    //5 내가 작성한 글 보기

    //7 페이징 처리 및 검색
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        System.out.println("sc in searchResultCnt() = " + sc);
        System.out.println("session = " + session);
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public List<AllqnaDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    }


    //8 조회수 처리
    @Override
    public int increaseViewCnt(Integer allqnaNo) throws Exception {
        return session.update(namespace+"increaseViewCnt", allqnaNo);
    }

}
