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

    @GetMapping("/list") //전체 학생 목록
    public String getList(SearchCondition sc, Model model) {

        try {
            //총 학생 수 페이징 클래스에 넘기기(페이징에 필요한 iv 초기화)
            int totalCnt = stdService.getSearchResultCnt(sc);
            Pageable pageable = new Pageable(sc, totalCnt);
            //navi에 사용하기 위해 모델에 전달
            model.addAttribute("totalCnt", totalCnt);

            //학생 목록 list 셀렉
            List<StdMemberManageDto> list = stdService.getSearchPage(sc);
            //jsp에 전달
            model.addAttribute("list", list);
            model.addAttribute("sc", sc);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            //에러 발생 시, 에러 msg 전달, 관리자 홈으로 이동
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "redirect:/admin/home";
        }
        return "/admin/stdManage/stdManageList";
    }


    @GetMapping("/read") //상세 페이지
    public String infoRead(Integer mebrNo, Integer page, Model model) {

        try {
            //전달받은 회원번호로 학생 조회
            StdMemberManageDto stdDto = stdService.read(mebrNo);
            //jsp에 전달
            model.addAttribute("stdDto", stdDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달, 학생 목록으로 이동
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/onlyAdmin/stdManage/list";
        }
        return "/admin/stdManage/stdManage";
    }


    @PostMapping("/modify")
    public String infoModify(Integer page, StdManageDto stdDto, Model model) {

        try {
            //입력받은 dto update
            stdService.modify(stdDto);
            //성공 msg 전달
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 읽기 화면으로 이동, 에러 msg 전달
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/stdManage/read?page=" + page + "&mebrNo=" + stdDto.getMebrNo();
        }
        return "redirect:/onlyAdmin/stdManage/read?page="+page+"&mebrNo="+stdDto.getMebrNo();
    }

    @PostMapping("/modifyStatus") //메인 페이지 상태 일괄 수정
    public String statusModify(Integer[] mebrNoArr, Integer page, Integer status, Model model) {
        try {
            //전달 받은 회원 번호 배열 list에 담기
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            //상태와 배열 전달
            stdService.modifyStatus(status, mebrNo);
            //성공 시 msg jsp에 전달
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달, list에 리다이렉트
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/onlyAdmin/stdManage/list?page=" + page;
        }

        return "redirect:/onlyAdmin/stdManage/list?page=" + page;
    }

    @PostMapping("/delete") //상세보기 화면에서 삭제
    public String stdDelete(Integer mebrNo, Integer page, Model model) {

        try {
            //전달받은 회원번호로 학생 삭제
            stdService.remove(mebrNo);
            //성공 msg 전달
            model.addAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달, 읽기 화면으로 리다이렉트
            model.addAttribute("msg", "DEL_ERR");
            return "redirect:/onlyAdmin/stdManage/read?page=" + page + "&mebrNo=" + mebrNo;

        }

        return "redirect:/onlyAdmin/stdManage/list?page=" + page;

    }

    @PostMapping("/deleteMain") //메인화면에서 삭제
    public String stdDeleteMain(Integer[]mebrNoArr, Integer page, Model model) {

        try {
            //전달받은 회원번호 배열 list에 담기
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            //회원 배열 전달
            stdService.removeMain(mebrNo);
            //성공 시, msg jsp에 전달
            model.addAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달, 목록 페이지로 리다이렉트
            model.addAttribute("msg", "DEL_ERR");
            return "redirect:/onlyAdmin/stdManage/list?page=" + page;

        }

        return "redirect:/onlyAdmin/stdManage/list";

    }


}
