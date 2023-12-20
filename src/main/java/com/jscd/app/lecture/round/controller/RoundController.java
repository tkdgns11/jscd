package com.jscd.app.lecture.round.controller;

import com.jscd.app.lecture.round.dto.RoundDto;
import com.jscd.app.lecture.round.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/adminManage/registRound")
//@RequestMapping("/registRound")
public class RoundController {
    @Autowired
    RoundService roundService;

    // 등록된 회차 수정 기능 구현
    @PostMapping("/modifyRound")
    public String modifyRound(RoundDto roundDto, RedirectAttributes rattr, Model m) {
        try {
            roundService.modifyRound(roundDto);
            return "redirect:/adminManage/registRound/round";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(roundDto);
            return "roundRegist";
        }
    }

    // 등록된 회차 삭제 기능 구현
    @PostMapping("/removeRound")
    public String removeRound(Integer roundCode, Model m, RedirectAttributes rattr) throws Exception {
        try {
            roundService.removeRound(roundCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
        return "redirect:/adminManage/registRound/round";
    }

    // 등록된 회차 상세 확인 기능 구현
    @GetMapping("/roundDetail")
    public String detailRound(Integer roundCode, Model m) throws Exception {
        try {
            RoundDto roundDto = roundService.readRound(roundCode);
            m.addAttribute(roundDto);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/adminManage/registRound/round";
        }
        return "lecture/round/roundRegist";
    }

    // 회차 추가하는 페이지 이동 기능 구현
    @GetMapping("/addRound")
    public String addRound(Model m) throws Exception {
        try {
            m.addAttribute("mode", "new");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return "lecture/round/roundRegist";
    }

    // 회차 추가 기능 구현
    @PostMapping("/addRound")
    public String addRound(RoundDto roundDto, Model m) throws Exception {
        try {
            roundService.addRound(roundDto);
            return "redirect:/adminManage/registRound/round";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("roundDto", roundDto);
            return "roundRegist";
        }
    }

    // 등록된 회차 리스트 이동 기능 구현
    @GetMapping("/round")
    public String listRound(RoundDto roundDto, Model m) {
        try {
            List<RoundDto> list = roundService.getRoundList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "lecture/round/roundList";
    }
}
