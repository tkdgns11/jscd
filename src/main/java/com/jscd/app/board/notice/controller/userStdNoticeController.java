package com.jscd.app.board.notice.controller;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.pageHandler;
import com.jscd.app.board.notice.dto.stdNoticeDto;
import com.jscd.app.board.notice.service.stdNoticeService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/board/userStd/*")
public class userStdNoticeController {
    @Autowired
    stdNoticeService stdNoticeService;
    @Autowired
    MemberService memberService;



    @GetMapping("/read")

    public String read(int bno, Integer page, Integer pageSize, Model m, HttpServletRequest request) { //읽어온 걸 jsp로 전달해야해서 model

        if(!loginCheck(request))
            return "redirect:/member/login?toUrl="+request.getRequestURL();

        try {
            stdNoticeDto stdNoticeDto = stdNoticeService.read(bno); //서비스에서 읽고 dto로 받기


            m.addAttribute(stdNoticeDto); //이름 생략가능 -> 타입의 첫글자가 소문자로 바뀌고 이름으로 저장
            m.addAttribute("page", page); //여기서 잘 모르겠음;; page? 를 sc에서 가져오는 거 아니었나?
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/notice/userStdAllNotice";
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
            int totalCnt = stdNoticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            pageHandler pageHandler = new pageHandler(totalCnt, sc);

            List<stdNoticeDto> list = stdNoticeService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);


        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "list_err");
            m.addAttribute("totalCnt", 0);
        }
        return "board/notice/userStdNoticeList";
    }

}



