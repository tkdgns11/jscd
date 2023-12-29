package com.jscd.app.board.notice.controller;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.noticeDto;
import com.jscd.app.board.notice.dto.pageHandler;
import com.jscd.app.board.notice.dto.stdNoticeDto;
import com.jscd.app.board.notice.service.NoticeService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/board/notice/*")
public class noticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    MemberService memberService;

    @GetMapping("/read")
    public String read(int bno, Integer page, Integer pageSize, Model m) { //읽어온 걸 jsp로 전달해야해서 model

        try {
            noticeDto noticeDto = noticeService.read(bno); //서비스에서 읽고 dto로 받기

            m.addAttribute(noticeDto); //이름 생략가능 -> 타입의 첫글자가 소문자로 바뀌고 이름으로 저장
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/notice/allNotice";
    }

    @GetMapping("/list")
    public String list(SearchCon sc, Model m) throws Exception {

        try {
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            pageHandler pageHandler = new pageHandler(totalCnt, sc);

            List<noticeDto> list = noticeService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            System.out.println("list = " + list);
            m.addAttribute("ph", pageHandler);



        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "list_err");
            m.addAttribute("totalCnt", 0);
        }
        return "board/notice/noticeList";
    }

    @PostMapping("/remove") //게시물 삭제 POST방식만 있음
    public String remove(noticeDto noticeDto, Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {

        System.out.println("noticeDto = " + noticeDto);
        System.out.println("bno = " + bno);

        String writer = (String) session.getAttribute("adminId");



        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize); //모델에 담아주면 리다이렉트할 때 뒤에 자동으로 붙음

            int rowCnt = noticeService.remove(bno, writer);

            if (rowCnt != 1)
                throw new Exception("Delete error");
            rattr.addFlashAttribute("msg", "del_fin"); //flash -> 메세지가 일회성

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addAttribute("msg", "del_err");
        }

        return "redirect: /board/notice/list";
    }

    @GetMapping("/write")  //게시판 작성을 위한 빈 화면을 보여준다
    public String write(Model m, SearchCon sc) {



        m.addAttribute("mode", "new");
        m.addAttribute("page", sc.getPage());
        m.addAttribute("pageSize", sc.getPageSize());

        return "board/notice/allNotice"; //읽기와 쓰기에 사용, 쓰기에 사용할 때는 mode=new , new가 아닐 때에는 읽기만!
    }

    @PostMapping("/write")
    @ResponseBody
    public Map<String, String> write(@RequestBody noticeDto noticeDto, Integer page, Integer pageSize, Model m, RedirectAttributes rattr, HttpSession session) {
        Map<String, String> map = new HashMap<>();

        String writer = (String)session.getAttribute("adminId");
        noticeDto.setWriter(writer);

        try {
            int rowCnt = noticeService.write(noticeDto);

            if (rowCnt != 1)
                throw new Exception("Write Failed");

            rattr.addFlashAttribute("msg", "wrt_ok");
            map.put("redirect", "/board/notice/list");

        } catch (Exception e) {
            e.printStackTrace();
//            m.addAttribute(noticeDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "wrt_err");

        }
        return map;

    }



    @PostMapping("/modify")
    @ResponseBody
    public Map<String, String> modify(@RequestBody noticeDto noticeDto,Integer page, Integer pageSize, HttpSession session, Model m, RedirectAttributes rattr) { //사용자가 입력한 정보를 다시 돌려줘야해서 그걸 model에 담아둬야함

//        String writer = (String) session.getAttribute("adminId");
//        String noticeWriter= noticeDto.getWriter();
//
//        if (!writer.equals(noticeWriter)){
//            m.addAttribute("msg","modify_err");
//            return "board/notice/allNotice";
//        }

        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        System.out.println("noticeDto = " + noticeDto);
        Map<String, String> map = new HashMap<>();


        try {


            int rowCnt = noticeService.modify(noticeDto);
            System.out.println("rowCnt = " + rowCnt);
            if (rowCnt != 1)
                throw new Exception("Modify Failed");

            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            Integer bno = noticeDto.getBno();

            map.put("redirect", "/board/notice/read?bno="+bno+"&page="+page+"&pageSize="+pageSize);

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(noticeDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("msg", "mod_err");
            map.put("redirect", "/board/notice/noticeList");
            return map;

        }

    }


}



