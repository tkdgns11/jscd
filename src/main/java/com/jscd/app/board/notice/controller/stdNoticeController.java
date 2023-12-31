package com.jscd.app.board.notice.controller;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.pageHandler;

import com.jscd.app.board.notice.service.stdNoticeService;
import com.jscd.app.board.notice.dto.stdNoticeDto;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/board/stdNotice/*")
public class stdNoticeController {
    @Autowired
    stdNoticeService stdNoticeService;
    @Autowired
    MemberService memberService;

    @GetMapping("/read")
    public String read(int bno, Integer page, Integer pageSize, Model m) { //읽어온 걸 jsp로 전달해야해서 model
        try {
            stdNoticeDto stdNoticeDto = stdNoticeService.read(bno); //서비스에서 읽고 dto로 받기


            m.addAttribute(stdNoticeDto); //이름 생략가능 -> 타입의 첫글자가 소문자로 바뀌고 이름으로 저장
            m.addAttribute("page", page); //여기서 잘 모르겠음;; page? 를 sc에서 가져오는 거 아니었나?
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/notice/stdNotice";
    }

    @GetMapping("/list")
    public String list(SearchCon sc, Model m, HttpServletRequest request) throws Exception {

//            if(!loginCheck(request))
//                return "redirect:/member/login?toUrl="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

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

        return "board/notice/stdNoticeList";
    }

    @PostMapping("/remove") //게시물 삭제 POST방식만 있음
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {

        String writer = (String)session.getAttribute("adminId");

        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize); //모델에 담아주면 리다이렉트할 때 뒤에 자동으로 붙음

            int rowCnt = stdNoticeService.remove(bno, writer);

            if (rowCnt != 1)
                throw new Exception("Delete error");
            rattr.addFlashAttribute("msg", "del_fin"); //flash -> 메세지가 일회성

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addAttribute("msg", "del_err");
        }

        return "redirect: /board/stdNotice/list";
    }

    @GetMapping("/write")  //게시판 작성을 위한 빈 화면을 보여준다
    public String write(Model m, SearchCon sc) {


        m.addAttribute("mode", "new");
        m.addAttribute("page", sc.getPage());
        m.addAttribute("pageSize", sc.getPageSize());


        return "board/notice/stdNotice"; //읽기와 쓰기에 사용, 쓰기에 사용할 때는 mode=new , new가 아닐 때에는 읽기만!
    }

    @PostMapping("/write")
    public String write(stdNoticeDto stdNoticeDto, HttpSession session, Model m, RedirectAttributes rattr) { //사용자가 입력한 정보를 다시 돌려줘야해서 그걸 model에 담아둬야함

        String writer = (String)session.getAttribute("adminId");
        stdNoticeDto.setWriter(writer);


        try {

            int rowCnt = stdNoticeService.write(stdNoticeDto);

            System.out.println(stdNoticeDto);

            if (rowCnt != 1)
                throw new Exception("Write Failed");

            rattr.addFlashAttribute("msg", "wrt_ok"); //세션을 이용한 일회성 저장

            return "redirect:/board/stdNotice/list";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(stdNoticeDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "wrt_err");

            return "board/notice/stdNotice";

        }
    }

    @PostMapping("/modify")
    @ResponseBody
    public Map<String, String> modify(@RequestBody stdNoticeDto stdNoticeDto, Integer page, Integer pageSize, HttpSession session, Model m, RedirectAttributes rattr) { //사용자가 입력한 정보를 다시 돌려줘야해서 그걸 model에 담아둬야함

        String writer = (String) session.getAttribute("id");
        stdNoticeDto.setWriter(writer);

        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        Map<String, String> map = new HashMap<>();

        try {
            int rowCnt = stdNoticeService.modify(stdNoticeDto);

            System.out.println("rowCnt = " + rowCnt);

            if (rowCnt != 1)
                throw new Exception("Modify Failed");

            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            Integer bno = stdNoticeDto.getBno();
            map.put("redirect", "/board/stdNotice/read?bno="+bno+"&page="+page+"&pageSize="+pageSize);

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(stdNoticeDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("msg", "mod_err");
            map.put("redirect", "/board/stdNotice/noticeList");
            return map;

        }
    }}



