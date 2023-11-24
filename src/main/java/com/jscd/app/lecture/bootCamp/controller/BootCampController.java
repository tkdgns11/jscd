package com.jscd.app.lecture.bootCamp.controller;

import com.jscd.app.lecture.bootCamp.dto.BootCampRegistHandler;
import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import com.jscd.app.lecture.bootCamp.service.BootCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/btregist")
public class BootCampController {
    @Autowired
    BootCampService bootCampService;

    @GetMapping("/read")
    public String read(Integer classEnrollNo, Integer page, Integer pageSize, Model m) throws Exception {
        try {
            BootCampDto bootCampDto = bootCampService.read(classEnrollNo);
            m.addAttribute(bootCampDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/btregist/list";
        }
        return "lecture/bootCamp/bootCampRegist";
    }

    @GetMapping("list")
    public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request){
//        if(!loginCheck(request))
//            return "redirect:/login/login?toURL="+request.getRequestURL();

        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try{
            int totalCnt = bootCampService.getCount();      // count만지면 page
            BootCampRegistHandler sh = new BootCampRegistHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1) * pageSize);
            map.put("pageSize", pageSize);

            List<BootCampDto> list = bootCampService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("sh", sh);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "lecture/bootCamp/bootCampRegistList";
    }

//    private boolean loginCheck(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return session.getAttribute("id")!=null;
//    }
}
