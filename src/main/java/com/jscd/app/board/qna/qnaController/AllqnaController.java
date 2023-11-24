package com.jscd.app.board.qna.qnaController;

import com.jscd.app.board.qna.qnaDto.AllqnaDto;
import com.jscd.app.board.qna.qnaDto.AllqnacDto;
import com.jscd.app.board.qna.qnaDto.PageHandler;
import com.jscd.app.board.qna.qnaService.AllqnaCmmtService;
import com.jscd.app.board.qna.qnaService.AllqnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
    @Autowired
    AllqnaCmmtService allqnaCmmtService;


    @GetMapping("/qnaForm")
    public String qnaForm() {

        return "/board/qna/allqna";
    }

    @GetMapping("/allqnaList")
    public String allqnaList(Model model) throws Exception {
        List<AllqnaDto> list = allqnaService.getList();
        System.out.println("list값 확인"+list);
        model.addAttribute("list", list);

        return "/board/qna/allqnaList";
    }

    @GetMapping("/pageControll")
    public String pageControll(@RequestParam(defaultValue ="1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,Model m, HttpServletRequest request) throws Exception {

            int totalCnt = allqnaService.getCount();
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            if(page < 0 || page > pageHandler.getTotalPage())
                page = 1;
            if(pageSize < 0 || pageSize > 50)
                pageSize = 10;

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<AllqnaDto> list = allqnaService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

        return "/board/qna/allqnaList";
    }


    @PostMapping("/qnaWrite")
    public String qnaWrite(AllqnaDto allqnaDto) throws Exception {
        allqnaService.write(allqnaDto);
        return "redirect:/board/qna/allqnaList";
    }

    @GetMapping("/allqnaDetail") //
    public String read(@RequestParam("allqnaNo") Integer allqnaNo, Model model) throws Exception {
        AllqnaDto allqnaDto = allqnaService.read(allqnaNo);
        model.addAttribute("read", allqnaDto);
        System.out.println("allqnaNo 값"+allqnaNo);

        List<AllqnacDto> list = allqnaCmmtService.getList(allqnaNo);
        model.addAttribute("comment", list);
        System.out.println("맵퍼에서 컨트롤러까지 넘어오는 값 : " + list);

        return "board/qna/allqnaCont"; // 얘는 또 detail안됨
    }

    @GetMapping("/allqnaModify")
    //@RequestMapping(value = "/allqnqModify", method = RequestMethod.GET)
    //@PathVariable("id") Integer id, Model model)
    public String allqnaModify(@RequestParam("allqnaNo") Integer allqnaNo, Model model) throws Exception {
        System.out.println("수정하기버튼 클릭했을때?");
        AllqnaDto allqnaDto = allqnaService.read(allqnaNo);
        System.out.println("수정 : " + allqnaDto);
        model.addAttribute("modify", allqnaDto);
        return "/board/qna/allqnaModify";
    }

//    객체로 안가져와서 안되나


    //수정완료된 페이지 어떻게?
    @PostMapping("/allqnaModified")
    public String allqnaModified(AllqnaDto allqnaDto, Model model, RedirectAttributes rttr) throws Exception {

        allqnaService.modify(allqnaDto);
        model.addAttribute("modified", allqnaDto);

        rttr.addFlashAttribute("result", "modify success");

        return "redirect:/board/qna/allqnaList";

    }

    @GetMapping("/allqnaDelete")
    public String allqnaDelete(int allqnaNo, RedirectAttributes rttr) throws Exception {

        allqnaService.remove(allqnaNo);
        rttr.addFlashAttribute("delete", "delete success");

        return "redirect:/board/qna/allqnaList";
    }


    @PostMapping("/cmmtWrite")
    public String cmmtWrite(AllqnacDto allqnacDto) throws Exception {
        allqnaCmmtService.write(allqnacDto);
//        System.out.println("댓글입력 컨트롤러 디비값 : " + allqnaCmmtService.write(allqnacDto));

        return "redirect:/board/qna/allqnaDetail?allqnaNo=" + allqnacDto.getAllqnaNo();
    }


//댓글 리스트 ㅇ
//댓글 인서트 후 뷰 ㅇ (근데 왜 detail이 된건지 모르겠음)
//댓글 수정 삭제


    @GetMapping("/cmmtModify")
    public String cmmtModify(@RequestParam("allqnaCNo") Integer allqnacNo, AllqnacDto allqnacDto, Model model) throws Exception {

        model.addAttribute("modify", allqnaCmmtService.modify(allqnacDto));
        return "redirect:/board/qna/allqnaDetail?allqnaNo=" + allqnacDto.getAllqnaNo();
    }


    @GetMapping("/cmmtDelete")
    public String cmmtDelete(int allqnaCNo , AllqnacDto allqnacDto, RedirectAttributes rttr) throws Exception {


        try {
            allqnaCmmtService.delete(allqnaCNo);
            rttr.addFlashAttribute("delete", "delete success");
        } catch (Exception ex) {
            // 삭제 도중 예외가 발생하면 로그에 기록
            logger.severe("삭제 중 오류 발생: " + ex.getMessage());
        }
//        allqnaCmmtService.delete(allqnacDto);
//        rttr.addFlashAttribute("delete", "delete success");
//
//        System.out.println("댓글삭제 : " + allqnacDto);
        return "redirect:/board/qna/allqnaDetail?allqnaNo=" + allqnacDto.getAllqnaNo();
    }
}



