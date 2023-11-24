package com.jscd.app.board.qna.qnaDao;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;

import java.util.List;
import java.util.Map;

public interface AllqnaDao {
    int insert(AllqnaDto allqnadto) throws Exception;
    List <AllqnaDto> selectAll() throws Exception;

    AllqnaDto select(Integer allqnaNO) throws Exception;
    int increaseViewCnt(Integer allqnaNO) throws Exception;

    int update(AllqnaDto dto) throws Exception;

    int delete(Integer allqnaNo) throws Exception;

    int count() throws Exception;

    List<AllqnaDto> selectPage(Map map) throws Exception;


}
