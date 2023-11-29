package com.jscd.app.admin.controller;


import com.jscd.app.admin.domain.Pageable;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;
import com.jscd.app.admin.service.StdManageService;
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
	작성 기능:학생 정보 읽기/수정
	 */

@Controller
@RequestMapping("/onlyAdmin/stdManage")
public class StdManageController {
    @Autowired
    StdManageService stdService;

    @GetMapping("/list")
    public String getList(SearchCondition sc, Model model) {

        try {
            int listCnt = stdService.getSearchResultCnt(sc);
            Pageable pageable = new Pageable(sc, listCnt);
            List<StdMemberManageDto> list = stdService.getSearchPage(sc);
            model.addAttribute("list", list);
            model.addAttribute("sc", sc);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
        }
        return "/admin/stdManage/stdManageList";
    }


    @GetMapping("/read")
    public String infoRead(Integer mebrNo, Integer page, Model model) {

        try {
            StdMemberManageDto stdDto = stdService.read(mebrNo);
            model.addAttribute("stdDto", stdDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
        }
        return "/admin/stdManage/stdManage";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer page, Integer mebrNo, Model model) {
        try {
            StdMemberManageDto stdDto = stdService.read(mebrNo);
            model.addAttribute("page", page);
            model.addAttribute("stdDto", stdDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/admin/stdManage/stdManageModify";
    }

    @PostMapping("/modify")
    public String infoModify(Integer page, StdManageDto stdDto, Model model) {

        try {
            stdService.modify(stdDto);
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "MOD_ERR");
            model.addAttribute("stdDto", stdDto);
            return "redirect:/onlyAdmin/stdManage/modify";
        }
        return "redirect:/onlyAdmin/stdManage/list?page=" + page;
    }


}
