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

import javax.servlet.http.HttpSession;
import java.util.List;

	/*
	작성일:20231122
	작성자:김보영
	작성 기능:강사 정보 읽기/수정
	 */

@Controller
@RequestMapping("/onlyAdmin/instructor")
public class InstructorInfoController {
    @Autowired
    InstructorInfoService infoService;

    //전체 목록 가져오기
    @GetMapping("/list")
    public String getList(SearchCondition sc, Model model, HttpSession session) {

        try {
            //쿼리스트링으로 들어온 객체 jsp에 뿌려주기(페이징,검색 관련 iv 담겨있다)
            model.addAttribute("sc", sc);
            //(1-1)총 게시물 개수를 받아와서
            int listCnt = infoService.getSearchResultCnt(sc);
            //(1-2)페이징 처리 객체 매개변수로 넣어준다
            Pageable pageable = new Pageable(sc, listCnt);
            //(1-3)jsp에서의 페이징 처리를 위해 모델로 넘겨준다
            model.addAttribute("page", pageable);

            //(2-1)강사 정보를 list에 받고,
            List<InstructorMemberInfoDto> list = infoService.getSearchPage(sc);
            //(2-2)jsp에 뿌려주기
            model.addAttribute("list", list);

        } catch (Exception e) {
            e.printStackTrace();
            //에러 존재 시, 메세지를 jsp에 넘기기
            model.addAttribute("msg", "LIST_ERR");
        }
        return "/admin/instructorManage/instructorInfoList";
    }

    //강사 상세 정보 읽기
    @GetMapping("/read")
    public String infoRead(String iscrNo, Integer page, Model model) {

        try {
            //쿼리스트링으로 넘어온 iscrNo로 강사 데이터를 select
            InstructorMemberInfoDto infoDto = infoService.read(iscrNo);
            //객체를 jsp에 넘겨주기
            model.addAttribute("infoDto", infoDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
        }

        return "/admin/instructorManage/instructorInfo";
    }

    //강사 정보 수정 페이지
    @GetMapping("/modify")
    public String modifyForm(Integer page, String iscrNo, Model model) {
        try {
            InstructorMemberInfoDto infoDto = infoService.read(iscrNo);
            model.addAttribute("page", page);
            model.addAttribute("infoDto", infoDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/admin/instructorManage/instructorInfoModify";
    }


    @PostMapping("/modify")
    public String infoModify(Integer page, InstructorInfoDto instructorInfoDto, Model model) {

        try {
            infoService.modify(instructorInfoDto);
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //작성 중인 내용 그대로 띄우도록 jsp에 전달
            model.addAttribute("instructorInfoDto", instructorInfoDto);
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/instructor/modify";
        }

        return "redirect:/onlyAdmin/instructor/list?page=" + page;
    }


}

