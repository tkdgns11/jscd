package com.jscd.app.lecture.bootCamp.controller;

import com.jscd.app.lecture.bootCamp.domain.BootCampRegistHandler;
import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import com.jscd.app.lecture.bootCamp.service.BootCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rigst")
public class BootCampController {
    @Autowired
    BootCampService bootCampService;

    // 부트캠프 등록하기.
    @GetMapping("/add")
    public String bootCampRegister() {
        return "bootCampRegister";
    }

    // 등록된 부트캠프 확인하기.
    @GetMapping("/list")
    public String registeredLecture(Integer page, Integer pageSize, Model m, HttpServletRequest request) throws Exception {
//        if(!loginCheck(request))
//            return "redirect:/admin/login?toURL="+request.getRequestURL();
        try {
            int totalCnt = bootCampService.getCount();
            m.addAttribute("totalCnt", totalCnt);

            BootCampRegistHandler pageHandler = new BootCampRegistHandler(totalCnt, page, pageSize);

            if(page < 0 || page > pageHandler.getTotalPage())
                page = 1;
            if(pageSize < 0 || pageSize > 50)
                pageSize = 10;

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<BootCampDto> list = bootCampService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return "bootCampList";
    }

    // 등록된 부트캠프 수정하기.
    @PostMapping("/modify")
    public String modify(BootCampDto bootCampDto, Model m, HttpSession session) {
        String writer = (String)session.getAttribute("adminNo");
        return "";
    }

    // 등록된 부트캠프 삭제하기.
    @PostMapping("/remove")
    public String remove(BootCampDto bootCampDto, HttpSession session) {
        return "";
    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("id")!= null;
    }

}
