package com.jscd.app.board.qna.qnaDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
public class StdQnaDto {
    private int stdQnaNo; //qna 번호
    private int qnactNo;
    private int mebrNo;
    private String title;
    private String writer;
    private String content;
    private int hit;
    private String openYN;
    private Date regDate;
    private String frsidNmbr;
    private Date modifyDate;
    private String lstidNmbr;
    private String etc;

    private String name; // qnact 테이블의 name

    public StdQnaDto() {}

    
}
