package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;

import java.util.List;

public interface AllqnaCmmtDao {

//        int count(Integer bno) throws Exception;
//        int deleteAll(Integer bno);
          int delete(int allqnaCNo) throws Exception;
          int insert(AllqnacDto allqnacDto) throws Exception;
          List<AllqnacDto> selectAll(Integer allqnaNo) throws Exception;

         AllqnacDto select(Integer allqnaCNo) throws Exception;
         int update(AllqnaDto allqnaDto) throws Exception;
         int update(AllqnacDto allqnacDto) throws Exception;


}
