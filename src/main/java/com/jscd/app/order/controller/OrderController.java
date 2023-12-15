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
import java.util.List;

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


        return null;
    }

    @PostMapping("/actPaySuccess")
    @ResponseBody
    public String submitOrder2(@RequestBody  StodDTO stodDto) throws Exception {
        System.out.println("서버 측에서 주문 처리 중"+ stodDto);

        //주문 정보 DB에 넣기
        stodService.insertStod(stodDto);

        //결제 정보 DB에 넣기
        stodService.insertPayHty(stodDto);


        return null;
    }
    
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
    public String getOrderList(Model model, HttpServletRequest request) throws Exception {
        // 1. 로그인한 사용자의 아이디 이용하여 '주문 내역' 조회
        // 세션에서 사용자 아이디 가져오기
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        // 2. 가져온 아이디를 StodService의 selectOrderList()에 전달 후 '주문 내역' 조회
        List<StodDTO> orderList = stodService.selectOrderList(id);
        // 3. 조회한 '주문 내역'을 Model 객체에 추가 후 orderList.jsp에 전달
        model.addAttribute("orderList", orderList);

        // 4. return 값 설정 : "/order/orderList" URL
        return "order/orderList";
    }

    // 주문 상세 내역 조회
    // 1. 주문 ID(id)와 주문 번호(odNo) : URL 경로 변수로 받기
//    @GetMapping("/{id}/{odNo}")
//    public ResponseEntity<List<StodDTO>> selectOrderDetail(@PathVariable("id") String id, @PathVariable("odNo") String odNo) throws Exception {
//        // 2. StodService의 selectOrderDetail() 호출 -> 주문 상세 내역 조회
//        List<StodDTO> orderDetail = stodService.selectOrderDetail(id, odNo);
//        // 3. 조회된 결과 -> HTTP 응답 본문으로 반환
//        return ResponseEntity.ok(orderDetail);
//    }
    @GetMapping("/orderDetail")
    public String selectOrderDetail(@RequestParam("odNo") String odNo, HttpServletRequest request, Model model) throws Exception {
        // 세션에서 로그인한 사용자의 ID를 가져옵니다.
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        
        System.out.println("orederDetail 시작"+id+", odNo"+odNo);
        // 로그인한 사용자의 ID와 odNo를 사용하여 주문 상세 정보를 조회합니다.
        List<StodDTO> orderDetail = stodService.selectOrderDetail(id, odNo);
        System.out.println("orderDetail ===" + orderDetail);
        // Model 객체에 주문 상세 정보를 추가합니다.
        model.addAttribute("orderDetail", orderDetail);

        // orderDetail.jsp 페이지를 반환합니다.
        return "order/orderDetail";
        
    }

    
    // 예외 발생 시 호출 및 exception.jsp 페이지로 이동
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception e) {
//        // 1. ModelAndView 객체 생성 : 예외 발생 시 exception.jsp 페이지로 이동
//        ModelAndView modelAndView = new ModelAndView("order/exception");
//        // 2. 예외 메시지 'errorMessage' 모델 속성으로 추가 (exception.jsp 페이지에서 사용할 수 있도록 하기 위함)
//        modelAndView.addObject("errorMessage", e.getMessage());
//        // 3. return값으로 ModelAndView 설정
//        return modelAndView;
//    }

}