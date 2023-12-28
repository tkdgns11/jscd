package com.jscd.app.admin.controller;

import com.jscd.app.admin.dto.CouponInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/coupon")
public class CouponViewController {

    @Autowired
    CouponService couponService;

    //관리자 쿠폰 조회,발급 페이지
    @GetMapping("/adminList")
    public String couponList(Model model, HttpServletRequest request) {

        List<CouponInfoDto> couponDtoList = couponService.GetCouponInfoList();

        System.out.println("couponDtoList = " + couponDtoList);

        model.addAttribute("couponList", couponDtoList);

        return "/admin/couponInfoList";
    }
}