package com.jscd.app.board.notice.controller;

import com.jscd.app.board.notice.dto.SearchCon;
import com.jscd.app.board.notice.dto.noticeDto;
import com.jscd.app.board.notice.dto.pageHandler;
import com.jscd.app.board.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/board/notice/*")
public class noticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("/read")
    public String read(int bno, Integer page, Integer pageSize, Model m) { //읽어온 걸 jsp로 전달해야해서 model
        try {
            noticeDto noticeDto = noticeService.read(bno); //서비스에서 읽고 dto로 받기
            m.addAttribute(noticeDto); //이름 생략가능 -> 타입의 첫글자가 소문자로 바뀌고 이름으로 저장
            m.addAttribute("page", page); //여기서 잘 모르겠음;; page? 를 sc에서 가져오는 거 아니었나?
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board/notice/allNotice";
    }

    @GetMapping("/list")
    public String list(SearchCon sc, Model m, HttpServletRequest request) throws Exception {
//            if(!loginCheck(request))
//                return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = noticeService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            pageHandler pageHandler = new pageHandler(totalCnt, sc);
            System.out.println("totalCnt = " + totalCnt);
            System.out.println("sc = " + sc);


            List<noticeDto> list = noticeService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);


        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "list_err");
            m.addAttribute("totalCnt", 0);
        }

        return "board/notice/noticeList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    @PostMapping("/remove") //게시물 삭제 POST방식만 있음
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {


        String writer = "memeber493";
//                (String)session.getAttribute("id");


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
    public String write(Model m) {
        m.addAttribute("mode", "new");
//        m.addAttribute("page", page);
//        m.addAttribute("pageSize", pageSize);

        System.out.println(m);
        return "board/notice/allNotice"; //읽기와 쓰기에 사용, 쓰기에 사용할 때는 mode=new , new가 아닐 때에는 읽기만!
    }

    @PostMapping("/write")
    public String write(noticeDto noticeDto, HttpSession session, Model m, RedirectAttributes rattr) { //사용자가 입력한 정보를 다시 돌려줘야해서 그걸 model에 담아둬야함
//        String writer =
//                (String) session.getAttribute("id");
//        noticeDto.setWriter(writer); //Dto에 작성자 저장
        System.out.println("여기까지 왔음");

        try {

            int rowCnt = noticeService.write(noticeDto);

            System.out.println(noticeDto);

            if (rowCnt != 1)
                throw new Exception("Write Failed");

            rattr.addFlashAttribute("msg", "wrt_ok"); //세션을 이용한 일회성 저장

            return "redirect:/board/notice/list";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(noticeDto);
            m.addAttribute("mode", "new");
            m.addAttribute("msg", "wrt_err");


            return "board/notice/allNotice";

        }

    }




    @PostMapping("/modify")
    public String modify(noticeDto noticeDto,Integer page, Integer pageSize, HttpSession session, Model m, RedirectAttributes rattr) { //사용자가 입력한 정보를 다시 돌려줘야해서 그걸 model에 담아둬야함
//        String writer = (String) session.getAttribute("id");
//        noticeDto.setWriter(writer);
        System.out.println("ddddd");
        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);

        try {
            int rowCnt = noticeService.modify(noticeDto);

            System.out.println("rowCnt = " + rowCnt);

            if (rowCnt != 1)
                throw new Exception("Modify Failed");

            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("msg", "mod_ok"); //세션을 이용한 저장

            return "board/notice/allNotice";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(noticeDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("msg", "mod_err");

            return "board/notice/noticeList";

        }

    }


}


//        private boolean loginCheck(HttpServletRequest request) {
//            // 1. 세션을 얻어서
//            HttpSession session = request.getSession();
//            // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//            return session.getAttribute("id")!=null;
//        }

