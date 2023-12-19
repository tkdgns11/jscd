package com.jscd.app.board.qna.qnaDto;

import java.util.Date;

public class StdqnaDto{

    private Integer stdqnaNo; //게시글 번호

    private Integer allqnaCmtNo; //댓글 번호 (조회수)
    private Integer allqnaCmtNum;// 댓글 Pk

    private Integer allqnaCmtReplyNo; //대댓글 번호
    private Integer qnaCtNo; //카테고리 번호
    private Integer mebrNo; //회원 번호
    private String title; //게시글 제목
    private String writer; //게시글 작성자
    private String content; //게시글 내용
    private String cmtWriter; //댓글 작성자
    private String cmtContent; //댓글 내용

    private Integer hit; //게시글 조회수
    private String openYN;
    private Date regDate;
    private Date cmtRegDate; //댓글 번호
    private Integer firstIdNo;
    private Date modifyDate;
    private Integer lastIdNo;
    private String etc;

}
