package com.jscd.app.admin.controller;


import com.jscd.app.admin.domain.Pageable;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;
import com.jscd.app.admin.service.StdManageService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
            int totalCnt = stdService.getSearchResultCnt(sc);
            model.addAttribute("totalCnt", totalCnt);

            Pageable pageable = new Pageable(sc, totalCnt);
            List<StdMemberManageDto> list = stdService.getSearchPage(sc);
            model.addAttribute("list", list);
            model.addAttribute("sc", sc);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "redirect:/admin/home";
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
            return "redirect:/onlyAdmin/stdManage/list";
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
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/onlyAdmin/stdManage/read?page=" + page + "&mebrNo=" + mebrNo;
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
            return "redirect:/onlyAdmin/stdManage/modify?page=" + page + "&mebrNo=" + stdDto.getMebrNo();
        }
        return "redirect:/onlyAdmin/stdManage/list?page=" + page;
    }

    @PostMapping("/modifyStatus")
    public String statusModify(Integer[] mebrNoArr, Integer page, Integer status, Model model) {
        try {
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            stdService.modifyStatus(status, mebrNo);
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/stdManage/list?page=" + page;
        }

        return "redirect:/onlyAdmin/stdManage/list?page=" + page;
    }

    @PostMapping("/delete") //상세보기 화면에서 삭제
    public String stdDelete(Integer mebrNo, Integer page, Model model) {

        try {
            stdService.remove(mebrNo);
            model.addAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "DEL_ERR");
            //에러 발생 시, 읽기 화면 그대로 보여지기
            return "redirect:/onlyAdmin/stdManage/read?page=" + page + "&mebrNo=" + mebrNo;

        }

        return "redirect:/onlyAdmin/stdManage/list?page=" + page;

    }

    @PostMapping("/deleteMain") //메인화면에서 삭제
    public String stdDeleteMain(Integer[]mebrNoArr, Integer page, Model model) {

        try {
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            stdService.removeMain(mebrNo);
            model.addAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "DEL_ERR");
            return "redirect:/onlyAdmin/stdManage/list?page=" + page;

        }

        return "redirect:/onlyAdmin/stdManage/list?page=" + page;

    }


}
