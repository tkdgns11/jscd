package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.ApplicationHandler;
import com.jscd.app.applyTraining.dto.SmApplicationDto;
import com.jscd.app.applyTraining.service.SmApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/onlyAdmin/adminSmTraining")
@RequestMapping("/adminSmTraining")
public class AdminSmTrainingController {
    @Autowired
    SmApplicationService smApplicationService;

    // 승인 여부 처리시
    @PostMapping("modify")
    public String smApplicationModify(SmApplicationDto smApplicationDto, Integer page, Integer pageSize, Model m, RedirectAttributes rattr){

        System.out.println("smApplicationDto = " + smApplicationDto);

        try {
            int cnt = smApplicationService.modify(smApplicationDto);

            if(cnt != 1)
                throw new Exception("modify failed");

            rattr.addFlashAttribute("page", page);
            rattr.addFlashAttribute("pageSize", pageSize);
            return "redirect:/adminSmTraining/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("smApplicationDto", smApplicationDto);
            m.addAttribute("page", page);
            m.addAttribute("page", pageSize);
            return "/applyTraining/adminSmApplication";
        }
    }

    @GetMapping("read")
    public String smApplicationRead(Integer stfmNo, Integer page, Integer pageSize, Model m){

        try {
            SmApplicationDto smApplicationDto =  smApplicationService.read(stfmNo);

            m.addAttribute("smApplicationDto", smApplicationDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/applyTraining/adminSmApplication";
    }

    @GetMapping("list")
    public String smApplicationList(Integer page, Integer pageSize, Model m){

        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;

        try {
            int totalCnt = smApplicationService.getCount();

            ApplicationHandler ah = new ApplicationHandler(totalCnt, page, pageSize);
            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);

            List<SmApplicationDto> list = smApplicationService.getPage(map);

            m.addAttribute("list", list);
            m.addAttribute("ah", ah);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/applyTraining/adminSmApplicationList";
    }
}
