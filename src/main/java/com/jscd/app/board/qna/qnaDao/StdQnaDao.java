package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.StdQnaDto;

import java.util.List;

public interface StdQnaDao {
    // 학사 질문&답변 목록 표시
    List<StdQnaDto> selectAllStdQna() throws Exception;
    // 게시글 하나 표시
    StdQnaDto selectOneStdQna(int stdQnaNo) throws Exception;
    // 게시글 최초 등록
    void insertStdQna(StdQnaDto stdQnaDto) throws Exception;
}
