package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.StdQnaDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StdQnaDaoImpl implements StdQnaDao {
    @Autowired
    private SqlSession sqlSession;
    private static String namespace = "com.jscd.app.board.qna.stdQnaMapper.";

    @Override
    public List<StdQnaDto> selectAllStdQna() throws Exception{
        return sqlSession.selectList(namespace+"selectAllStdQna");
    }

    @Override
    public StdQnaDto selectOneStdQna(int stdqnaNo) throws Exception{
        return sqlSession.selectOne(namespace+"selectOneStdQna", stdqnaNo);
    }
    
    // 게시글 최초 등록 
    @Override
    public void insertStdQna(StdQnaDto stdQnaDto) throws Exception{
        sqlSession.insert(namespace+"insertStdQna", stdQnaDto);
    }
}

