package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.AllqnaDao;
import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AllqnaServiceImpl implements AllqnaService {

    @Autowired
    AllqnaDao allqnaDao;

    @Override
    public int write(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.insert(allqnaDto);
    }

    public List<AllqnaDto> getList() throws Exception {
        return allqnaDao.selectAll();
    }

    public AllqnaDto read(Integer allqnaNo) throws Exception {
        AllqnaDto allqnaDto = allqnaDao.select(allqnaNo);
       allqnaDao.increaseViewCnt(allqnaNo);

        return allqnaDto;
    }

    @Override
    public int modify(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.update(allqnaDto);
    }

    @Override
    public int remove(Integer allqnaNo) throws Exception {
        return allqnaDao.delete(allqnaNo);
    }

    @Override
    public int getCount() throws Exception {
        return allqnaDao.count();
    }

    @Override
    public List<AllqnaDto> getPage(Map map) throws Exception {
        return allqnaDao.selectPage(map);
    }

}