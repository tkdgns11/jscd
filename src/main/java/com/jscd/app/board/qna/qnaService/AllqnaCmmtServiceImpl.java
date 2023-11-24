package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.AllqnaCmmtDao;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.jscd.app")
@Service
public class AllqnaCmmtServiceImpl implements AllqnaCmmtService {
    @Autowired
    AllqnaCmmtDao allqnaCmmtDao;

    @Override
    public int write(AllqnacDto allqnacDto) throws Exception {
        // System.out.println("댓글입력 서비스에 디비 넘어오는거 : "+ allqnaCmmtDao.insert(allqnacDto));
        return allqnaCmmtDao.insert(allqnacDto);
    }

    @Override
    public List<AllqnacDto> getList(Integer allqnaNo) throws Exception {
        // System.out.println("댓글 목록 서비스단 :" + allqnaCmmtDao.selectAll(allqnaNo)); // []넘어옴
       // String allqnaNoStr = String.valueOf(allqnaNo);
        return allqnaCmmtDao.selectAll(allqnaNo);
    }


    @Override
    public int delete(int allqnaCNo) throws Exception {
        return allqnaCmmtDao.delete(allqnaCNo);
    }

    @Override
    public Object modify(AllqnacDto allqnacDto) throws Exception{
         allqnaCmmtDao.update(allqnacDto);
        return null;
    }

//    @Override
//    public AllqnacDto select(int allqnaCNo) throws Exception {
//        return null;
//    }

    public AllqnacDto select(int allqnaCNo) throws Exception{
        return allqnaCmmtDao.select(allqnaCNo);
    }

}

