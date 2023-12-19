package com.jscd.app.board.qna.qnaController;

import com.jscd.app.board.qna.qnaDao.AllqnaDao;
import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.PageHandler;
import com.jscd.app.board.qna.qnaDto.QnActDto;
import com.jscd.app.board.qna.qnaDto.SearchCondition;
import com.jscd.app.board.qna.qnaService.AllqnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/board/qna/*")
public class AllqnaController {

    private static final Logger logger = Logger.getLogger(AllqnaController.class.getName());
    @Autowired
    AllqnaService allqnaService;


    //1-1. 게시글 등록 페이지 이동
    @GetMapping("/allqnaWrite")
    public String write(Model model) {
        model.addAttribute("mode", "new");
        return "/board/qna/allqnaWrite";
    }

    //게시글 등록하기
    @PostMapping("/allqnaWrite")
    @ResponseBody
    public Map<String, String> write(@RequestBody AllqnaDto allqnaDto, Model model, HttpSession session, RedirectAttributes rttr) {
        Map<String, String> map = new HashMap<>();

        //String writer = (String) session.getAttribute("id"); 로그인하면 아이디 가져오기
        //allqnaDto.setWriter(writer);

        try {

            if (allqnaService.write(allqnaDto) != 1) {
                throw new Exception("Write faild");
            }

            rttr.addFlashAttribute("msg", "WRITE_OK");
            map.put("redirect","/board/qna/allqnaList");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(allqnaDto);
            model.addAttribute("mode", "new");
            model.addAttribute("msg", "WRITE_ERR");
            map.put("redirect","/board/qna/allqnaList");

        }
        return map;

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


            return "/board/qna/allqnaList";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            model.addAttribute("totalCnt", 0);

            return "/board/qna/allqnaList";
        }

    }

    //1-3. 게시글 상세페이지 및 수정
    @GetMapping("/allqnaDetail")
    public String read(Integer allqnaNo, SearchCondition sc, RedirectAttributes rttr, Model model) {
        System.out.println(allqnaNo);
        try {
            //상세 내용 읽기
            AllqnaDto allqnaDto = allqnaService.read(allqnaNo);
            //System.out.println("allqnaDto==="+allqnaDto);
            model.addAttribute("allqnaList", allqnaDto);


            //댓글 내용 읽기
            List<AllqnaDto> cmtlist = allqnaService.cmtRead(allqnaNo);
            model.addAttribute("comment", cmtlist);


        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/board/qna/allqnaList" + sc.getQueryString();
        }


        return "/board/qna/allqnaWrite";
    }


    //1-3(2) 수정된 내용 등록하기
    @PostMapping("/allqnaModify")
    @ResponseBody
    public String allqnaModify(@RequestBody AllqnaDto allqnaDto, Model model, RedirectAttributes rttr) throws Exception {
        allqnaService.modify(allqnaDto);
        model.addAttribute("modified", allqnaDto);

        rttr.addFlashAttribute("result", "modify success");

        return "redirect:/board/qna/allqnaDetail?allqnaNo="+allqnaDto.getAllqnaNo();

    }


    //1-4. 게시글 삭제
    @PostMapping("/allqnaDelete")
    @ResponseBody
    public Map<String, String> remove(@RequestBody AllqnaDto allqnaDto, SearchCondition sc, RedirectAttributes rattr, HttpSession session) {
        Map<String, String> map = new HashMap<>();

        String writer = (String) session.getAttribute("id");
        String msg = "DEL_OK";
        System.out.println(allqnaDto.getAllqnaNo());
        writer = "대댓글111111ㅇㅇ";



        try {
            if (allqnaService.remove(allqnaDto.getAllqnaNo(), writer) != 1)
                throw new Exception("Delete failed.");

            map.put("redirect","/board/qna/allqnaList");
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";
            map.put("redirect","/board/qna/allqnaList");
        }

        //rattr.addFlashAttribute("msg", msg);
        return map;
    }


    //2-1 댓글 등록
    @PostMapping("/allqnaCmtWrite")
    @ResponseBody
    public Map<String, String> cmtWrite(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rttr, HttpSession session) {
        Map<String, String> map = new HashMap<>();

        //String writer = (String) session.getAttribute("id");

        try {
            //댓글 등록 실패하면 1이 아님
            if (allqnaService.cmtWrite(allqnaDto) != 1) {
                throw new Exception("Comment Write faild");
            }

            rttr.addFlashAttribute("msg", "WRITE_OK");
            //댓글 등록 성공 시 리다이렉트 allqnaNo 번호 값 넘겨서 조회
            map.put("redirect","/board/qna/allqnaDetail?allqnaNo="+allqnaDto.getAllqnaNo());


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(allqnaDto);
            model.addAttribute("mode", "new");
            model.addAttribute("msg", "WRITE_ERR");
            map.put("redirect","/board/qna/allqnaList");

        }
        return map;
    }
    //2-2 댓글 목록 (게시글 리스트에 있음)
    //2-3 댓글 수정
    @PostMapping("/allqnaCmtModify")
    @ResponseBody
    public Map<String, String> allqnaCmtModify(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rttr, HttpSession session) {
        Map<String, String> map = new HashMap<>();

        //String writer = (String) session.getAttribute("id");
        System.out.println(allqnaDto);

        try {
            //댓글 등록 실패하면 1이 아님
            if (allqnaService.cmtModify(allqnaDto) != 1) {
                throw new Exception("Comment Update faild");
            }

            rttr.addFlashAttribute("msg", "WRITE_OK");
            //댓글 등록 성공 시 리다이렉트 allqnaNo 번호 값 넘겨서 조회
            map.put("redirect","/board/qna/allqnaDetail?allqnaNo="+allqnaDto.getAllqnaNo());


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(allqnaDto);
            model.addAttribute("mode", "new");
            model.addAttribute("msg", "WRITE_ERR");
            map.put("redirect","/board/qna/allqnaList");

        }
        return map;
    }
    //2-5 댓글 삭제
    @PostMapping("/allqnaCmtDelete")
    @ResponseBody
    public Map<String, String> cmtDelete(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rattr, HttpSession session) throws Exception {
        Map<String, String> map = new HashMap<>();

//        String writer = (String) session.getAttribute("id");
        String msg = "DEL_OK";
//        System.out.println(allqnaDto.getAllqnaNo());
//        allqnaDto.setCmtWriter("aaaa");


        try {
            if (allqnaService.cmtReplyDelete(allqnaDto) != 1)
                throw new Exception("Delete failed.");

        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";

        }

        //rattr.addFlashAttribute("msg", msg);
        return map;
    }


    //3-1 대댓글 등록
    @PostMapping("/allqnaCmtReplyWrite")
    @ResponseBody
    public Map<String, String> allqnaCmtReplyWrite(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rttr, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        System.out.println("대댓글 수정 ======="+allqnaDto);
        //String writer = (String) session.getAttribute("id");
        try {
            //댓글 등록 실패하면 1이 아님
            if (allqnaService.cmtReplyWrite(allqnaDto) != 1) {
                throw new Exception("Comment Reply Write faild");
            }

            rttr.addFlashAttribute("msg", "WRITE_OK");
            //댓글 등록 성공 시 리다이렉트 allqnaNo 번호 값 넘겨서 조회
            map.put("redirect","/board/qna/allqnaDetail?allqnaNo="+allqnaDto.getAllqnaNo());


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute(allqnaDto);
            model.addAttribute("mode", "new");
            model.addAttribute("msg", "WRITE_ERR");
            map.put("redirect","/board/qna/allqnaList");

        }
        return map;
    }

    //3-2 대댓글 목록
    @PostMapping("/allqnaCmtReplyRead")
    @ResponseBody
    public List<AllqnaDto> allqnaCmtReplyRead(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rttr, HttpSession session) {


        //String writer = (String) session.getAttribute("id");
        List<AllqnaDto> replyList = new ArrayList<>();
        try {

            replyList = allqnaService.cmtReplyRead(allqnaDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return replyList;
    }

    //3-3 대댓글 수정
    @PostMapping("/allqnaCmtReplyUpdate")
    @ResponseBody
    public  Map<String, String> allqnaCmtReplyUpdate(@RequestBody AllqnaDto allqnaDto, Model model, RedirectAttributes rttr, HttpSession session) {
        System.out.println("댓글수정 등록 컨트롤러 ====="+allqnaDto);

        Map<String, String> map = new HashMap<>();
        //String writer = (String) session.getAttribute("id");

        try {
            allqnaService.cmtReplyModify(allqnaDto);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    //3-4 대댓글 삭제
    //2-5 댓글 삭제
    @PostMapping("/allqnaCmtReplyDelete")
    @ResponseBody
    public Map<String, String> allqnaCmtReplyDelete(@RequestBody AllqnaDto allqnaDto, Model model, SearchCondition sc, RedirectAttributes rattr, HttpSession session) throws Exception {
        Map<String, String> map = new HashMap<>();

        String writer = (String) session.getAttribute("id");
        String msg = "DEL_OK";
        allqnaDto.setCmtWriter("cccc");

        Integer allqnaNo = allqnaDto.getAllqnaNo();
        //상세 내용 읽기
        allqnaDto = allqnaService.read(allqnaNo);
        //System.out.println("allqnaDto==="+allqnaDto);
        model.addAttribute("allqnaList", allqnaDto);


        //댓글 내용 읽기
        List<AllqnaDto> list = allqnaService.cmtRead(allqnaNo);
        model.addAttribute("comment", list);

        try {
            if (allqnaService.cmtDelete(allqnaDto) != 1)
                throw new Exception("Delete failed.");

            map.put("redirect","/board/qna/");
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";
            map.put("redirect","/board/qna/allqnaDetail");
        }

        //rattr.addFlashAttribute("msg", msg);
        return map;
    }


    //4 비밀글 제외
    //5 내가 작성한 글 보기





}










