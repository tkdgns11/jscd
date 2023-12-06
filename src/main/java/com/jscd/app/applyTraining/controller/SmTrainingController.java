package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SmApplicationDto;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.applyTraining.service.SmApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/smTraining")
public class SmTrainingController {
    @Autowired
    SmApplicationService smApplicationService;

    // 부트캠프 신청서 제출 메서드
    @PostMapping("smApplication")
    public String smApplicationWrite(SmApplicationDto smApplicationDto, Model m, RedirectAttributes rattr){

        try {
            int cnt = smApplicationService.write(smApplicationDto);

            if(cnt != 1)
                throw new Exception("write err");

            rattr.addFlashAttribute("msg", "write ok");
            // 신청서 제출 후 결제 페이지로 이동해야 함.
            return null;
        } catch (Exception e) {
            // 신청서 제출 실패시
            // 작성했던 내용, 에러 메세지와 함께 신청서 페이지로 이동
            e.printStackTrace();
            m.addAttribute(smApplicationDto);
            m.addAttribute("msg", "write err");
            return "/applyTraining/smApplication";
        }
    }
    // 세미나 신청서
    @GetMapping("smApplication")
    public String btTrainingApplication(Model m){
        // registCode 얻어서 넘겨줘야 함.
        // mebrNo 얻어서 넘겨줘야 함.

        return "/applyTraining/smApplication";
    }
}
