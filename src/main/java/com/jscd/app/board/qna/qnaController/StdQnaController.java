package com.jscd.app.board.qna.qnaController;


import com.jscd.app.board.qna.qnaDto.StdQnaDto;
import com.jscd.app.board.qna.qnaService.StdQnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board/qna/*")
public class StdQnaController {
    @Autowired
    private StdQnaService stdQnaService;
    
    // 학사 질문&답변 목록 이동
    @GetMapping("/stdQnaList")
    public String stdQnaList(Model m, HttpSession session) throws  Exception {
        String id = (String) session.getAttribute("id");
        m.addAttribute("id", id);
        
        try {
            List<StdQnaDto> stdQnaList = stdQnaService.selectAllStdQna();
            m.addAttribute("stdQnaList", stdQnaList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/board/qna/stdQnaList";
    }

    // 학사 질문&답변 목록 -> 글쓰기 이동
    @GetMapping("/stdQnaWrite")
    public String stdQnaWrite() throws Exception {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/board/qna/stdQnaWrite";
    }
    
    // 학사 질문&답변 목록 중 타이틀 클릭 -> 해당 작성글 내용 확인
    @GetMapping("/stdQnaDetail")
    public String stdQnaDetail(@RequestParam("stdQnaNo") int stdQnaNo, Model m) throws Exception {
        try {
            StdQnaDto stdQnaDto = stdQnaService.stdQnaDetail(stdQnaNo);
            m.addAttribute("stdQnaDto", stdQnaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/board/qna/stdQnaWrite";
    }
    
    // 학사 질문&답변 최초 글 작성
    // 수정 해야함
    @PostMapping("/stdQnaWrite")
    public String registerStdQna(StdQnaDto stdQnaDto) throws Exception{
        try {
            stdQnaService.registerStdQna(stdQnaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board/qna/stdQnaList";
    }
    
}
