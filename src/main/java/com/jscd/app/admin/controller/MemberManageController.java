package com.jscd.app.admin.controller;

import com.jscd.app.admin.domain.Pageable;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.MemberManageDto;
import com.jscd.app.admin.service.AdminService;
import com.jscd.app.admin.service.MemberManageService;
import com.jscd.app.member.dto.MemberDto;
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
	작성 기능:회원 정보 읽기/수정
	 */

@Controller
@RequestMapping("/adminManage/memberManage")
public class MemberManageController {

    @Autowired
    MemberManageService manageService;
    @Autowired
    AdminService adminService;

    @GetMapping("/list") //전체 회원 목록 페이지
    public String getList(SearchCondition sc, Model model) {

        try {
            //1. 총 데이터 개수를 페이징 클래스에 전달 -> 페이징 초기화
            int listCnt = manageService.getSearchResultCnt(sc);
            System.out.println("게시물 개수 listCnt = " + listCnt);
            Pageable pageable = new Pageable(sc, listCnt);
            //2. 페이징 클래스를 넘기고, 데이터가 담긴 list 반환
            List<MemberManageDto> list = manageService.getSearchPage(sc);
            //3. jsp에 전달
            model.addAttribute("sc", sc);
            model.addAttribute("list", list);
            model.addAttribute("page", pageable);

        } catch (Exception e) {
            //에러 발생 시, 에러 msg 모델에 전달, 관리자 홈으로 이동
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "redirect:/admin/home";
        }
        return "/admin/memberManage/adminMemberManageList";
    }


    @GetMapping("/read") //회원 상세보기 페이지
    public String infoRead(Integer mebrNo, Integer page, Model model) {

        try { //전달 받은 회원번호로 회원 select
            MemberManageDto memberDto = manageService.read(mebrNo);
            System.out.println("회원 상세보기 memberDto = " + memberDto);
            //jsp에 전달
            model.addAttribute("memberDto", memberDto);
            model.addAttribute("page", page);
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 모델에 전달, list 목록으로 돌아가기
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/adminManage/memberManage/list";
        }

        return "/admin/memberManage/adminMemberManage";
    }


    @PostMapping("/modify") //상세 페이지 수정
    public String infoModify(Integer page, MemberDto memberDto, Model model,String originGrade) {


        try {
            //입력 받은 dto를 update
            manageService.modifyDetail(memberDto);
            MemberDto adminDel = manageService.readMember(memberDto.getMebrNo());
            if(originGrade.equals("관리자")){//기존 등급이 관리자라면, 관리자 테이블에서 삭제
                adminService.removeAdmin(adminDel.getId());
            }
            //성공 msg 모델에 전달
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //에러 발생 시, 에러 msg 전달, 읽기 화면으로 이동
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/adminManage/memberManage/read?page=" + page + "&mebrNo=" + memberDto.getMebrNo();
        }

        return "redirect:/adminManage/memberManage/read?page="+page+"&mebrNo="+memberDto.getMebrNo();
    }

    @PostMapping("/modifyMain") //메인 페이지 등급/상태 일괄 수정
    public String statusModify(Integer[] mebrNoArr, Integer status, Integer grade, Integer page, Model model) {
        try {
            //전달받은 회원 번호 배열을 list에 담기
            List mebrNo = new ArrayList(mebrNoArr.length);
            for (int i = 0; i < mebrNoArr.length; i++) {
                mebrNo.add(mebrNoArr[i]);
            }
            //상태,등급,회원번호 update
            manageService.modify(status, grade, mebrNo);
            //성공 msg 전달
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //실패 시, 에러 msg 전달. list 목록으로 리다이렉트
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/adminManage/memberManage/list?page=" + page;
        }

        return "redirect:/adminManage/memberManage/list?page=" + page;
    }


}
