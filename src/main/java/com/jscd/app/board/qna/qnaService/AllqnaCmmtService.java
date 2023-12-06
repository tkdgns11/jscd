package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;

import java.util.List;

public interface AllqnaCmmtService {

    int write(AllqnacDto allqnacDto) throws Exception;


    List<AllqnacDto> getList(Integer allqnaNo) throws Exception;

  AllqnacDto getList2(Integer allqnaCNo) throws Exception;

//    int delete(Integer allqnaCNo) throws Exception;

//    Object modify(AllqnacDto allqnacDto) throws Exception;
    int modify(AllqnacDto allqnacDto) throws Exception;

   AllqnacDto select(AllqnacDto allqnaCNo) throws Exception;

    void replyDelete(Integer allqnaCNo) throws Exception;
}

