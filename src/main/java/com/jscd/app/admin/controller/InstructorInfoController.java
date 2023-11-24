package com.jscd.app.admin.controller;

import com.jscd.app.admin.domain.Pageable;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import com.jscd.app.admin.service.InstructorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

	/*
	작성일:20231122
	작성자:김보영
	작성 기능:강사 정보 읽기/수정
	 */

@Controller
@RequestMapping("/instructor")
public class InstructorInfoController {
    @Autowired
    InstructorInfoService infoService;

    //전체 목록 가져오기
    @GetMapping("/list")
    public String getList(SearchCondition sc, Model model) {

        try {
            //총 게시물 개수
            int listCnt = infoService.getSearchResultCnt(sc);
            //페이징 처리
            Pageable pageable = new Pageable(sc, listCnt);
            List<InstructorMemberInfoDto> list = infoService.getSearchPage(sc);
            model.addAttribute("sc", sc);
            model.addAttribute("list", list);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
        }
        return "/admin/instructorInfoList";
    }

    @GetMapping("/read")
    public String infoRead(String iscrNo, Integer page, Model model) {

        try {
            InstructorMemberInfoDto infoDto = infoService.read(iscrNo);
            model.addAttribute("infoDto", infoDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
        }

        return "/admin/instructorInfo";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer page, String iscrNo, Model model) {
        try {
            InstructorMemberInfoDto infoDto = infoService.read(iscrNo);
            model.addAttribute("page", page);
            model.addAttribute("infoDto", infoDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/admin/instructorInfoModify";
    }


    @PostMapping("/modify")
    public String infoModify(Integer page, InstructorInfoDto instructorInfoDto, Model model) {

        try {
            infoService.modify(instructorInfoDto);
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/instructor/modify";
        }

        return "redirect:/instructor/list?page=" + page;
    }


}

