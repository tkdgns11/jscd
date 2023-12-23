package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.QnActDto;
import com.jscd.app.board.qna.qnaDto.SearchCondition;

import java.util.List;

public interface AllqnaService {

    //1-1. 게시글 등록
    int write(AllqnaDto allqnaDto) throws Exception;
    //1-2. 게시글 목록 읽기 (페이징 처리)
    List<AllqnaDto> getList(SearchCondition sc) throws Exception;
    //1-3 게시글 1개 읽기
    AllqnaDto read(Integer allqnaNo) throws Exception;
    //1-4 게시글 수정
    int modify(AllqnaDto allqnaDto) throws Exception;
    //1-5 게시글 삭제
    int remove(Integer allqnaNo, String writer) throws Exception;


    //2-1 댓글 등록
    int cmtWrite(AllqnaDto allqnaDto) throws Exception;
    //2-2 댓글 목록
    List<AllqnaDto> cmtRead(Integer allqnaNo) throws Exception;
    //2-3 댓글 수정
    int cmtModify(AllqnaDto allqnaDto) throws Exception;
    //2-4 댓글 삭제
    int cmtDelete(AllqnaDto allqnaDto) throws Exception;



    //3-1 대댓글 등록
    int cmtReplyWrite(AllqnaDto allqnaDto) throws Exception;


    //3-2 대댓글 목록
    List<AllqnaDto> cmtReplyRead(AllqnaDto allqnaDto) throws Exception;


    //3-3 대댓글 수정
    int cmtReplyModify(AllqnaDto allqnaDto) throws Exception;
    //3-4 대댓글 삭제
    int cmtReplyDelete(AllqnaDto allqnaDto) throws Exception;

    //4 비밀글 제외
    //5 내가 작성한 글 보기

    //7 게시글 페이지 처리 및 검색
    int getSearchResultCnt(SearchCondition sc) throws Exception;
    List<AllqnaDto> getSearchResultPage(SearchCondition sc) throws Exception;

    //카테고리
//    QnActDto allqnaCategory(Integer qnaCtNo) throws Exception;

//    List<AllqnaDto> getNonSecretSearchResultPage(SearchCondition sc);
    int searchResultCntExepctSecret(SearchCondition sc) throws Exception;

    List<AllqnaDto> searchSelectPageExceptSecret(SearchCondition sc) throws Exception;

}