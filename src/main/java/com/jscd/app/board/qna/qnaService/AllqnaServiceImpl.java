package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.AllqnaDao;
import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import com.jscd.app.board.qna.qnaDto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllqnaServiceImpl implements AllqnaService {

    @Autowired
    AllqnaDao allqnaDao;

    //1-1. 게시글 등록
    @Override
    public int write(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.insert(allqnaDto);
    }
    //1-2. 게시글 목록 읽기 (페이징 처리)

    @Override
    public List<AllqnaDto> getList(SearchCondition sc) throws Exception {
        return allqnaDao.selectList(sc);
    }

    //1-3 게시글 1개 읽기
    @Override
    public AllqnaDto read(Integer allqnaNo) throws Exception {
        AllqnaDto allqnaDto = allqnaDao.select(allqnaNo);
        allqnaDao.increaseViewCnt(allqnaNo);

        return allqnaDto;
    }

    //1-4. 게시글 수정
    @Override
    public int modify(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.update(allqnaDto);
    }


    //1-5. 게시글 삭제
    @Override
    public int remove(Integer allqnaNo, String writer) throws Exception {
        return allqnaDao.delete(allqnaNo, writer);
    }

    //2. 검색

    //3-1 댓글 등록
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int cmmtWrite(AllqnacDto allqnacDto) throws Exception {
//        allqnaDao.updateCommentCnt(allqnacDto.getAllqnaNo(), 1);
//                throw new Exception("test");
        return allqnaDao.cmmtInsert(allqnacDto);
    }


    //3-2 댓글 목록

    public List<AllqnacDto> cmmtRead(Integer allqnaNo) throws Exception {
        return allqnaDao.selectAll(allqnaNo);
    }

    //3-3 댓글 수정

    @Override
    public int cmmtModify(AllqnacDto allqnacDto) throws Exception {
        System.out.println("서비스 댓글 수정 : "+ allqnacDto);
        return allqnaDao.cmmtUpdate(allqnacDto);
    }

    //3-4 댓글 삭제

    //4-1 대댓글 등록
    //4-2 대댓글 목록
    //4-3 대댓글 수정
    //4-4 대댓글 삭제

    //5 비밀글 제외
    //6 내가 작성한 글 보기

    //7 페이징 처리 및 검새
    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return allqnaDao.searchResultCnt(sc);
    }

    @Override
    public List<AllqnaDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return allqnaDao.searchSelectPage(sc);
    }

}



