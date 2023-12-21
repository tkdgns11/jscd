package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.QnActDto;
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
    public int cmtInsert(AllqnaDto allqnaDto) throws Exception {
        return session.insert(namespace+"cmtInsert", allqnaDto);
    }

    //2-2 댓글 목록
    @Override
    public List<AllqnaDto> cmtSelect(Integer allqnaNo) throws Exception {
        return session.selectList(namespace+"cmtSelect", allqnaNo);
    }


    //2-3 댓글 수정
    @Override
    public int cmtUpdate(AllqnaDto allqnaDto) throws Exception {
        return session.update(namespace+"cmtUpdate", allqnaDto);
    }


    //2-4 댓글 삭제
    @Override
    public int cmtDelete(AllqnaDto allqnaDto) throws Exception {
        return session.delete(namespace + "cmtDelete", allqnaDto);
    }



    //3-1 대댓글 등록
    @Override
    public int cmtReplyInsert(AllqnaDto allqnaDto) throws Exception {
        return session.insert(namespace + "cmtReplyInsert", allqnaDto);
    }
    //3-2 대댓글 목록
    @Override
    public List<AllqnaDto> cmtReplySelectList(AllqnaDto allqnaDto) throws Exception {
        return session.selectList(namespace+"cmtReplySelect", allqnaDto);
    }
    //3-3 대댓글 수정
    @Override
    public int cmtReplyUpdate(AllqnaDto allqnaDto) throws Exception {
        return session.update(namespace+"cmtReplyUpdate",allqnaDto);
    }

    //3-4 대댓글 삭제
    @Override
    public int cmtReplyDelete(AllqnaDto allqnaDto) throws Exception {
        return session.delete(namespace+"cmtReplyDelete", allqnaDto);
    }


    //4 비밀글 제외
    //5 내가 작성한 글 보기

    //7 페이징 처리 및 검색
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public List<AllqnaDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    }


    //9 조회수 처리
    @Override
    public int increaseViewCnt(Integer allqnaNo) throws Exception {
        return session.update(namespace+"increaseViewCnt", allqnaNo);
    }


    //카테고리
    @Override
    public QnActDto allqnaCategory(Integer qnaCtNo) throws Exception {
        System.out.println("카테고리 매퍼======="+session.selectOne(namespace+"allqnaCategory", qnaCtNo));
        return null;
    }

}
