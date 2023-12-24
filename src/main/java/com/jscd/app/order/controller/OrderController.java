package com.jscd.app.order.controller;

/*
작성일:20231122
작성자:박소희
작성 기능: 결제 및 주문
 */

import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import com.jscd.app.order.dto.CompanyInfoDTO;
import com.jscd.app.order.dto.OrderDTO;
import com.jscd.app.order.dto.StodDTO;
import com.jscd.app.order.service.CompanyInfoService;
import com.jscd.app.order.service.OrderService;
import com.jscd.app.order.service.StodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CompanyInfoService companyInfoService;
    private final StodService stodService;

    private final MemberService memberService;

    //config.properties 파일 내 포트원 결제 API 이용하기 위한 계정 가져오기 위함
//    @Value("${IMP_KEY}")
//    private String impKey;


    @Autowired
    public OrderController(OrderService orderService, CompanyInfoService companyInfoService, StodService stodService, MemberService memberService) {
        this.orderService = orderService;
        this.companyInfoService = companyInfoService;
        this.stodService = stodService;
        this.memberService = memberService;
    }

    @GetMapping("/order")
    public String showOrderPage(@RequestParam("registCode") int registCode, Model model, MemberDto memberDto, OrderDTO orderDto, CompanyInfoDTO companyInfoDto, HttpServletRequest request) throws Exception {
        // registCode 변수는 이제 URL 매개변수로 전달받음
        System.out.println("order");
        try{
            // 회원 정보 가져오기
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("id");

            memberDto = memberService.memberSelect(id);
            model.addAttribute("memberDto", memberDto);

            // 강의 정보 가져오기
            orderDto = orderService.getOrder(registCode);
            model.addAttribute("orderDto", orderDto);
            System.out.println(orderDto.toString());

            companyInfoDto.setSlrNo(1); //231207 류소희 강의 등록 시 회사 번호도 등록해야함...
            // 회사 정보 가져오기
            companyInfoDto = companyInfoService.select(companyInfoDto.getSlrNo());
            model.addAttribute("companyInfoDto", companyInfoDto);
            System.out.println(companyInfoDto.toString());

        } catch (Exception e){
            System.out.println("order error");
        }
        return "order/order";
    }

    @PostMapping("/paySuccess")
    @ResponseBody
    public String submitOrder(@RequestBody  StodDTO stodDto) throws Exception {
        System.out.println("서버 측에서 주문 처리 중"+ stodDto);

        //주문 정보 DB에 넣기
        stodService.insertStod(stodDto);

        //결제 정보 DB에 넣기
        stodService.insertPayHty(stodDto);

        //주문 상태를 'paid'로 업데이트
        stodService.updateStatusToPaid(stodDto.getId(), stodDto.getRegistCode());

        return null;
    }

//    @PostMapping("/paySuccess")
//    @ResponseBody
//    public String submitOrder(@RequestBody  StodDTO stodDto, @ModelAttribute("orderDto") OrderDTO orderDto, Model model) throws Exception {
//        System.out.println("서버 측에서 주문 처리 중"+ stodDto);
//
//        //주문 정보 DB에 넣기
//        stodService.insertStod(stodDto);
//
//        //결제 정보 DB에 넣기
//        stodService.insertPayHty(stodDto);
//
//        // orderDto 정보 보내기
//        model.addAttribute("orderDto", orderDto);
//
//        return "order/paySuccess";
//    }

    @PostMapping("/actPaySuccess")
    @ResponseBody
    public String submitOrder2(@RequestBody  StodDTO stodDto, @ModelAttribute("orderDto") OrderDTO orderDto, Model model) throws Exception {
        System.out.println("서버 측에서 주문 처리 중"+ stodDto);

        //주문 정보 DB에 넣기
        stodService.insertStod(stodDto);

        //결제 정보 DB에 넣기
        stodService.insertPayHty(stodDto);

        // orderDto 정보 보내기
        model.addAttribute("orderDto", orderDto);
        System.out.println(orderDto);

        //주문 상태를 'paid'로 업데이트
        stodService.updateStatusToPaid(stodDto.getId(), stodDto.getRegistCode());

        return "order/actPaySuccess";
    }
//  원래
//    @PostMapping("/actPaySuccess")
//    @ResponseBody
//    public String submitOrder2(@RequestBody  StodDTO stodDto) throws Exception {
//        System.out.println("서버 측에서 주문 처리 중"+ stodDto);
//
//        //주문 정보 DB에 넣기
//        stodService.insertStod(stodDto);
//
//        //결제 정보 DB에 넣기
//        stodService.insertPayHty(stodDto);
//
//
//        return null;
//    }

//    @PostMapping("/actPaySuccess")
//    public String submitOrder2(@RequestBody StodDTO stodDto) throws Exception {
//        System.out.println("서버 측에서 주문 처리 중" + stodDto);
//
//        // 주문 정보 DB에 넣기
//        stodService.insertStod(stodDto);
//
//        // 결제 정보 DB에 넣기
//        stodService.insertPayHty(stodDto);
//
//        // "/order/actPaySuccess" 뷰 이름 반환
//        return "redirect:/order/actPaySuccess?odNo=" + stodDto.getOdNo();
//    }
//
//    @GetMapping("/order/actPaySuccess")
//    public String showOrderSuccess(@RequestParam String odNo, Model model) {
//        StodDTO stodDto = stodService.getStodByOdNo(odNo);
//        model.addAttribute("stodDto", stodDto);
//        return "/order/actPaySuccess";
//    }




    // 카드 결제 완료 페이지 연결
    @GetMapping("/paySuccess")
    public String paySuccess() {
        return "order/paySuccess";
    }

    // 계좌이체 결제 완료 페이지 연결
    @GetMapping("/actPaySuccess")
    public String actPaySuccess() {
        return "order/actPaySuccess";
    }

    // 주문 내역 조회 페이지 연결
    @GetMapping("/orderList")
    public String getOrderList(@RequestParam(defaultValue = "1") int page, Model model, MemberDto memberDto, CompanyInfoDTO companyInfoDto, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        int itemsPerPage = 5; // 페이지당 보여줄 아이템 수 (StodServiceImpl.java - selectOrderList()와 연결 됨)
        List<StodDTO> orderList = stodService.selectOrderList(id, page, itemsPerPage);
        model.addAttribute("orderList", orderList);

        memberDto = memberService.memberSelect(id);
        model.addAttribute("memberDto", memberDto);
        System.out.println(memberDto.toString());

        companyInfoDto.setSlrNo(1); //231207 류소희 강의 등록 시 회사 번호도 등록해야함...
        // 회사 정보 가져오기
        companyInfoDto = companyInfoService.select(companyInfoDto.getSlrNo());
        model.addAttribute("companyInfoDto", companyInfoDto);
        System.out.println(companyInfoDto.toString());

        int totalItems = stodService.countOrderList(id); // 전체 아이템 수를 조회
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
        model.addAttribute("totalPages", totalPages);

        // 현재 페이지 번호를 모델에 추가
        model.addAttribute("currentPage", page);

        return "order/orderList";
    }





    @GetMapping("/orderDetail")
    public String selectOrderDetail(@RequestParam("odNo") String odNo, HttpServletRequest request, Model model) throws Exception {
        // 세션에서 로그인한 사용자의 ID 가져오기
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        System.out.println("orederDetail 시작"+id+", odNo"+odNo);
        // 로그인한 사용자의 ID와 odNo를 사용하여 주문 상세 정보 조회
        List<StodDTO> orderDetail = stodService.selectOrderDetail(id, odNo);
        System.out.println("orderDetail ===" + orderDetail);
        // Model 객체에 주문 상세 정보 추가
        model.addAttribute("orderDetail", orderDetail);

        // orderDetail.jsp 페이지 반환
        return "order/orderDetail";
    }


    // 예외 발생 시 호출 및 exception.jsp 페이지로 이동
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        // 1. ModelAndView 객체 생성 : 예외 발생 시 exception.jsp 페이지로 이동
        ModelAndView modelAndView = new ModelAndView("order/exception");
        // 2. 예외 메시지 'errorMessage' 모델 속성으로 추가 (exception.jsp 페이지에서 사용할 수 있도록 하기 위함)
        modelAndView.addObject("errorMessage", e.getMessage());
//         3. return값으로 ModelAndView 설정
        return modelAndView;
    }

}