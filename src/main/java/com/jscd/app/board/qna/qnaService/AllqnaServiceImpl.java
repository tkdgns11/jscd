package com.jscd.app.board.qna.qnaService;

import com.jscd.app.board.qna.qnaDao.AllqnaDao;
import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.QnActDto;
import com.jscd.app.board.qna.qnaDto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllqnaServiceImpl implements AllqnaService {

    @Autowired
    AllqnaDao allqnaDao;

    //1-1. 게시글 등록
    @Override
    public int write(AllqnaDto allqnaDto) throws Exception {
        System.out.println("service===="+allqnaDto);
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


    //2-1 댓글 등록
    @Override
    public int cmtWrite(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtInsert(allqnaDto);
    }



    //2-2 댓글 목록
    @Override
    public List<AllqnaDto> cmtRead(Integer allqnaNo) throws Exception {
        return allqnaDao.cmtSelect(allqnaNo);
    }


    //2-3 댓글 수정
    @Override
    public int cmtModify(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtUpdate(allqnaDto);
    }

    //2-4 댓글 삭제
    @Override
    public int cmtDelete(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtDelete(allqnaDto);
    }




    //3-1 대댓글 등록
    @Override
    public int cmtReplyWrite(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtReplyInsert(allqnaDto);
    }


    //3-2 대댓글 목록
    @Override
    public List<AllqnaDto> cmtReplyRead(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtReplySelectList(allqnaDto);
    }
    //3-3 대댓글 수정
    @Override
    public int cmtReplyModify(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtReplyUpdate(allqnaDto);
    }
    //3-4 대댓글 삭제
    @Override
    public int cmtReplyDelete(AllqnaDto allqnaDto) throws Exception {
        return allqnaDao.cmtReplyDelete(allqnaDto);
    }




    //4 비밀글 제외
    //5 내가 작성한 글 보기

    //6 게시글 페이징 처리 및 검새
    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return allqnaDao.searchResultCnt(sc);
    }

    @Override
    public List<AllqnaDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return allqnaDao.searchSelectPage(sc);
    }


    //카테고리
    @Override
    public QnActDto allqnaCategory(Integer qnaCtNo) throws Exception {
        return allqnaDao.allqnaCategory(qnaCtNo);
    }

//    @Override
//    public List<AllqnaDto> getNonSecretSearchResultPage(SearchCondition sc) throws Exception {
//     return null;
//    }

}



