package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.StdQnaDao;
import com.jscd.app.board.qna.qnaDto.StdQnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdQnaServiceImpl implements StdQnaService {
    @Autowired
    private StdQnaDao stdQnaDao;

    @Override
    public List<StdQnaDto> selectAllStdQna() throws Exception{
        return stdQnaDao.selectAllStdQna();
    }
    
    @Override
    public StdQnaDto stdQnaDetail(int stdQnaNo) throws Exception{
        return stdQnaDao.selectOneStdQna(stdQnaNo);
    }
    
    //게시글 최초 등록
    @Override
    public void  registerStdQna(StdQnaDto stdQnaDto) throws Exception{
        stdQnaDao.insertStdQna(stdQnaDto);
    }
}

