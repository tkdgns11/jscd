package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;

import java.util.List;
import java.util.Map;

public interface AllqnaService {

    int write(AllqnaDto allqnadto) throws Exception;

  List<AllqnaDto> getList() throws Exception;
  AllqnaDto read(Integer allqnaDto) throws Exception;

  int modify(AllqnaDto allqnaDto) throws Exception;

  int remove(Integer allqnaNo) throws Exception;


  int getCount() throws Exception;

  List<AllqnaDto> getPage(Map map) throws Exception;

}