package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.AllqnaCmmtDao;
import com.jscd.app.board.qna.qnaDto.AllqnaDto;
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
        return allqnaCmmtDao.insert(allqnacDto);
    }

    @Override
    public List<AllqnacDto> getList(Integer allqnaNo) throws Exception {
        // System.out.println("댓글 목록 서비스단 :" + allqnaCmmtDao.selectAll(allqnaNo)); // []넘어옴
        // String allqnaNoStr = String.valueOf(allqnaNo);
        return allqnaCmmtDao.selectAll(allqnaNo);
    }

    @Override
    public AllqnacDto getList2(Integer allqnaCNo) throws Exception {
        return allqnaCmmtDao.selectAll2(allqnaCNo);
    }



//    @Override
//    public int delete(AllqnacDto allqnacDto) throws Exception {
//        return allqnaCmmtDao.delete(allqnacDto);
  //  }


    @Override
    public void replyDelete(Integer allqnaCNo) throws Exception {
        System.out.println(allqnaCNo);
         allqnaCmmtDao.delete(allqnaCNo);
    }


    //    @Override
//    public Object modify(AllqnacDto allqnacDto) throws Exception {
//        return allqnaCmmtDao.select(allqnacDto);
// }
    @Override
    public int modify(AllqnacDto allqnacDto) throws Exception {
        return allqnaCmmtDao.update(allqnacDto);
    }
//    @Override
//    public AllqnacDto select(int allqnaCNo) throws Exception {
//        return null;
//    }

    @Override
    public AllqnacDto select(AllqnacDto allqnaCNo) throws Exception {
        return allqnaCmmtDao.select(allqnaCNo);
    }

}

