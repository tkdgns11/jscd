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
import java.util.ArrayList;
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
            int totalCnt = infoService.getSearchResultCnt(sc);

            //(1-2)페이징 처리 객체 매개변수로 넣어준다
            Pageable pageable = new Pageable(sc, totalCnt);
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
            return "redirect:/admin/home";
        }
        return "/admin/instructorManage/instructorInfoList";
    }

    //강사 상세 정보 읽기+수정
    @GetMapping("/read")
    public String infoRead(Integer mebrNo, Integer page, Model model) {

        try {
            //쿼리스트링으로 넘어온 iscrNo로 강사 데이터를 select
            InstructorMemberInfoDto infoDto = infoService.read(mebrNo);

            //객체를 jsp에 넘겨주기
            model.addAttribute("infoDto", infoDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/onlyAdmin/instructor/list";
        }
        return "/admin/instructorManage/instructorInfo";
    }


    @PostMapping("/modify") //상세 페이지 수정
    public String infoModify(Integer page, InstructorInfoDto instructorInfoDto, Model model) {
        try {
            //입력받아 넘어온 dto update
            infoService.modify(instructorInfoDto);
            //에러 없다면, 성공msg 모델에 전달
            model.addAttribute("msg", "MOD_OK");

        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달 _ 읽기 화면으로 이동
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/instructor/read?page=" + page + "&mebrNo=" + instructorInfoDto.getMebrNo();
        }

        return "redirect:/onlyAdmin/instructor/read?page=" + page + "&mebrNo=" + instructorInfoDto.getMebrNo();
    }

    //메인화면 수정
    @PostMapping("/modifyStatus")
    public String statusModify(Integer[] mebrNoArr, Integer page, Integer status, Model model) {
        try {
            //jsp에서 전달받은 회원번호 배열 List에 담아주기
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            //수정 메서드에 전달
            infoService.modifyStatus(status, mebrNo);

            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 현재 화면(list)에 에러 msg 전달
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/instructor/list?page=" + page;
        }

        return "redirect:/onlyAdmin/instructor/list?page=" + page;
    }


}

