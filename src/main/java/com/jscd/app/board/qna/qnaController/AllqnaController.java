package com.jscd.app.board.qna.qnaController;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import com.jscd.app.board.qna.qnaDto.PageHandler;
import com.jscd.app.board.qna.qnaDto.SearchCondition;
import com.jscd.app.board.qna.qnaService.AllqnaCmmtService;
import com.jscd.app.board.qna.qnaService.AllqnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/board/qna/*")
public class AllqnaController {

    private static final Logger logger = Logger.getLogger(AllqnaController.class.getName());
    @Autowired
    AllqnaService allqnaService;
    @Autowired
    AllqnaCmmtService allqnaCmmtService;


    //1-1. 게시글 등록
    @GetMapping("/allqnaWrite")
    public String write(Model model) {
        model.addAttribute("mode", "new");
        return "/board/qna/allqna";
    }

    @PostMapping("/allqnaWrite")
    public String write(Model model, AllqnaDto allqnaDto, HttpSession session, RedirectAttributes rttr) {

        String writer = (String) session.getAttribute("id");
        allqnaDto.setWriter(writer);

        try {
            if (allqnaService.write(allqnaDto) != 1) {
                throw new Exception("Write faild");
            }
            rttr.addFlashAttribute("msg", "WRITE_OK");
            return "redirect:/board/qna/allqnaList";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(allqnaDto);
            model.addAttribute("mode", "new");
            model.addAttribute("msg", "WRITE_ERR");
            return "/board/qna/allqnaList";
        }


    }

    //1-2. 게시글 목록 읽기 (페이징 처리) 페이지 이동
    @GetMapping("/allqnaList")
    public String allqnaList(SearchCondition sc, Model model, AllqnaDto allqnaDto) throws Exception {

        try {

            int totalCnt = allqnaService.getSearchResultCnt(sc);
            model.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<AllqnaDto> list = allqnaService.getSearchResultPage(sc);
            model.addAttribute("list", list);
            model.addAttribute("ph", pageHandler);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            model.addAttribute("totalCnt", 0);
        }
        return "/board/qna/allqnaList";
    }

    //1-3. 게시글 수정
    @GetMapping("/allqnaDetail")
    public String read(Integer allqnaNo, SearchCondition sc, RedirectAttributes rttr, Model model) {
        try {
            //상세 내용
            AllqnaDto allqnaDto = allqnaService.read(allqnaNo);
            model.addAttribute("read", allqnaDto);

            //댓글
            List<AllqnacDto> list = allqnaService.cmmtRead(allqnaNo);
            model.addAttribute("comment", list);
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/board/qna/allqna" + sc.getQueryString();
        }


        return "board/qna/allqnaCont";
    }

    //1-4. 게시글 삭제

    @GetMapping("/allqnaDelete")
    public String remove(Integer allqnaNo, SearchCondition sc, RedirectAttributes rattr, HttpSession session) {
        String writer = (String) session.getAttribute("id");
        String msg = "DEL_OK";

        try {
            if (allqnaService.remove(allqnaNo, writer) != 1)
                throw new Exception("Delete failed.");
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";
        }

        rattr.addFlashAttribute("msg", msg);
        return "redirect:/board/qna/allqnaList" + sc.getQueryString();
    }

    //3-1 댓글 등록
    @PostMapping("/cmmtWrite")
    public String write(AllqnacDto allqnacDto, Integer allqnaNo, HttpSession session) throws Exception {

        allqnacDto.setAllqnaNo(allqnaNo);
        allqnaService.cmmtWrite(allqnacDto);
        return "redirect:/board/qna/allqnaDetail?allqnaNo=" + allqnacDto.getAllqnaNo();

    }


    //3-2 댓글 목록 (게시글 리스트에 있음)

    //3-3 댓글 수정

    @PostMapping("/cmmtModify/{allqnaCNo}")
    public String cmmtModify(@RequestParam("allqnaCNo") Integer allqnaCNo,
                             @RequestParam("content") String content,
                             @ModelAttribute AllqnacDto allqnacDto) throws Exception {
        System.out.println("컨트롤러 댓글수정 : " + allqnacDto);
        allqnacDto.setAllqnaCNo(allqnaCNo);
        allqnacDto.setContent(content);
        allqnaService.cmmtModify(allqnacDto);


        return "redirect:/board/qna/allqnaDetail?allnqaNo=" + allqnacDto.getAllqnaNo();

    }
}


    //3-4 댓글 삭제
//    @ResponseBody
//    @DeleteMapping("/comments/{cno}")  // DELETE /comments/1?bno=1085  <-- 삭제할 댓글 번호
//    public String remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
////
//        try {
//            int rowCnt = allqnaService.remove(allqnaCNo, allqnaNo);
//
//            if (rowCnt != 1)
//                throw new Exception("Delete Failed");
//
//            return "redirect:/board/qna/allqnaDetail?allnqaNo=" + allqnaNo();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "DEL_ERR";
//        }
//    }\]]\
    //]
//}



//4-1 대댓글 등록
//4-2 대댓글 목록
//4-3 대댓글 수정
//4-4 대댓글 삭제

//5 비밀글 제외
//6 내가 작성한 글 보기









