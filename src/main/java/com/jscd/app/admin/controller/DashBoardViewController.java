package com.jscd.app.admin.controller;

import com.jscd.app.admin.dto.DailySummaryDto;
import com.jscd.app.admin.service.AdminService;
import com.jscd.app.admin.service.DashBoardService;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.applyTraining.service.SmApplicationService;
import com.jscd.app.lecture.lstRegist.service.LstService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dashBoard")
public class DashBoardViewController {

    @Autowired
    DashBoardService dashBoardService;

    @Autowired
    MemberService memberService;

    @Autowired
    AdminService adminService;

    @Autowired
    LstService lstService;

    @Autowired
    BtApplicationService btApplicationService;

    @Autowired
    SmApplicationService smApplicationService;

    @GetMapping("/home")
    public String DashBoard(Model model, HttpServletRequest request) throws Exception {
        
        List<DailySummaryDto> dailySummaryDtoList = dashBoardService.initViewData();

        System.out.println("dailySummaryDtoList = " + dailySummaryDtoList);

        model.addAttribute("dailySummaryDtoList", dailySummaryDtoList);
        model.addAttribute("weekData", dashBoardService.getWeekData());
        model.addAttribute("monthData", dashBoardService.getMonthData());

        model.addAttribute("member", memberService.getGeneralMember());
        model.addAttribute("student", memberService.getStudentMember());
        model.addAttribute("admin", adminService.getCountAdmin());

        model.addAttribute("lstregist", lstService.getCountAll());
        model.addAttribute("lstregistBT", lstService.getCountBT());
        model.addAttribute("lstregistSM", lstService.getCountSM());

        model.addAttribute("btWaitingNum", btApplicationService.getWaitingNum());
        model.addAttribute("btApprovalNum", btApplicationService.getApprovalNum());
        model.addAttribute("btNotApprovalNum", btApplicationService.getNotApprovalNum());
        model.addAttribute("btWaitPayNum", btApplicationService.getWaitPayNum());
        model.addAttribute("btRegistNum", btApplicationService.getRegistNum());

        System.out.println("smApplicationService.getWaitPayNum() = " + smApplicationService.getWaitPayNum());
        System.out.println("smApplicationService.getRegistNum() = " + smApplicationService.getRegistNum());


        model.addAttribute("smWaitPayNum", smApplicationService.getWaitPayNum());
        model.addAttribute("smRegistNum", smApplicationService.getRegistNum());

        return "admin/dashBoard";
    }
}