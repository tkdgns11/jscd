package com.jscd.app.facility.controller;

import com.jscd.app.facility.dto.LockerDto;
import com.jscd.app.facility.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/locker")
public class LockerViewController {

    @Autowired
    LockerService lockerService;
    @GetMapping("/test")
    public String test(Model m, HttpServletRequest request){
        return "facility/facilityTest";
    }

    //관리자 락커 페이지
    @GetMapping("/adminList")
    public String lockerList(Model model, HttpServletRequest request) {

        List<LockerDto> lockerDtoList = lockerService.adminGetLockers();

        model.addAttribute("lockerList", lockerDtoList);

        return "facility/locker";
    }

    @GetMapping("/student")
    public String student(Model m, HttpServletRequest request){
        return "admin/stdManage/studentDetail";
    }
    @GetMapping("/dashboard")
    public String dashBoard(Model m, HttpServletRequest request){
        return "admin/dashBoard2";
    }

    @GetMapping("/dashboard2")
    public String dashBoard2(Model m, HttpServletRequest request){

        return "admin/dashBoard";
    }
}