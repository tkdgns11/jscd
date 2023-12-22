package com.jscd.app.board.notice.controller;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.noticeDto;
import com.jscd.app.board.notice.dto.pageHandler;
import com.jscd.app.board.notice.service.NoticeService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/board/user/*")
public class userNoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    MemberService memberService;

    @GetMapping("/read")
    public String read(int bno, Integer page, Integer pageSize, Model m, HttpServletRequest request) { //읽어온 걸 jsp로 전달해야해서 model


        try {
            noticeDto noticeDto = noticeService.read(bno); //서비스에서 읽고 dto로 받기

            m.addAttribute(noticeDto); //이름 생략가능 -> 타입의 첫글자가 소문자로 바뀌고 이름으로 저장
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/notice/userAllNotice";
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id")!=null;
    }

    @GetMapping("/list")
    public String list(SearchCon sc, Model m) throws Exception {

        try {
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            pageHandler pageHandler = new pageHandler(totalCnt, sc);

            List<noticeDto> list = noticeService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);


        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "list_err");
            m.addAttribute("totalCnt", 0);
        }
        return "board/notice/userNoticeList";
    }

}

//        private boolean loginCheck(HttpServletRequest request) {
//            // 1. 세션을 얻어서
//            HttpSession session = request.getSession();
//            // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//            return session.getAttribute("id")!=null;
//        }

