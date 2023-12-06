package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;

import java.util.List;

public interface AllqnaCmmtDao {

    //        int count(Integer bno) throws Exception;
//        int deleteAll(Integer bno);
    void delete(Integer allqnaCNo) throws Exception;

    int insert(AllqnacDto allqnacDto) throws Exception;

    List<AllqnacDto> selectAll(Integer allqnaNo) throws Exception;

    AllqnacDto selectAll2(Integer allqnaCNo) throws Exception;

    AllqnacDto select(AllqnacDto allqnacDto) throws Exception;

    int update(AllqnacDto allqnacDto) throws Exception;


}
