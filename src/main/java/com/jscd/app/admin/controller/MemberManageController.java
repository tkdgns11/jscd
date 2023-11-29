package com.jscd.app.admin.controller;

import com.jscd.app.admin.domain.Pageable;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.service.MemberManageService;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

	/*
	작성일:20231123
	작성자:김보영
	작성 기능:회원 정보 읽기/수정
	 */

@Controller
@RequestMapping("/onlyAdmin/memberManage")
public class MemberManageController {

    @Autowired
    MemberManageService manageService;

    @GetMapping("/list")
    public String getList(SearchCondition sc, Model model) {

        try {
            int listCnt = manageService.getSearchResultCnt(sc);
            Pageable pageable = new Pageable(sc, listCnt);
            List<MemberDto> list = manageService.getSearchPage(sc);
            model.addAttribute("sc", sc);
            model.addAttribute("list", list);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "redirect:/admin/home";
        }
        return "/admin/memberManage/memberManageList";
    }


    @GetMapping("/read")
    public String infoRead(Integer mebrNo, Integer page, Model model) {

        try {
            MemberDto memberDto = manageService.read(mebrNo);
            model.addAttribute("memberDto", memberDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/onlyAdmin/memberManage/list";
        }

        return "/admin/memberManage/memberManage";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer page, Integer mebrNo, Model model) {
        try {
            MemberDto memberDto = manageService.read(mebrNo);
            model.addAttribute("page", page);
            model.addAttribute("memberDto", memberDto);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/onlyAdmin/memberManage/read&page=" + page + "&mebrNo=" + mebrNo;

        }

        return "/admin/memberManage/memberManageModify";
    }

    @PostMapping("/modify")
    public String infoModify(Integer page, MemberDto memberDto, Model model) {

        try {
            manageService.modifyDetail(memberDto);
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "MOD_ERR");
            model.addAttribute("memberDto", memberDto);
            return "redirect:/onlyAdmin/memberManage/modify?page="+page+"&mebrNo=" + memberDto.getMebrNo();
        }

        return "redirect:/onlyAdmin/memberManage/list?page=" + page;
    }


}
