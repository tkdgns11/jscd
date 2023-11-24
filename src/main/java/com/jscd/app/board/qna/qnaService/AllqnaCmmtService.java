package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDto.AllqnacDto;

import java.util.List;

public interface AllqnaCmmtService {

int write(AllqnacDto allqnacDto) throws Exception;


    List<AllqnacDto> getList(Integer allqnaNo) throws Exception;
    int delete(int allqnaCNo) throws Exception;
    Object modify(AllqnacDto allqnacDto) throws Exception;

    AllqnacDto select(int allqnaCNo) throws Exception;
}

