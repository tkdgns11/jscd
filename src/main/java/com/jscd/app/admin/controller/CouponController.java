package com.jscd.app.admin.controller;

import com.jscd.app.admin.dto.CouponDto;
import com.jscd.app.admin.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;


    // 쿠폰 등록
    @PostMapping("/register")
    public ResponseEntity<?> createCoupons(@RequestBody List<CouponDto> couponDtos) {
        
//        couponDtos.stream().forEach(abc -> {
//            System.out.println("abc.toString() = " + abc.toString());
//        });

        System.out.println("컨트롤러 couponDtos = " + couponDtos);

        try {
            int result = couponService.registerCoupons(couponDtos);
            if (result > 0) {
                return ResponseEntity.ok().body(result + "개의 쿠폰이 발급되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰 발급에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("발급할 쿠폰을 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰 발급 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkCoupon(@RequestBody CouponDto CouponDto) {
        try {
            String couponID = CouponDto.getCouponID().trim(); // 좌우 공백 제거
            System.out.println("couponID = " + couponID);
            int result = couponService.checkCoupon(couponID);
            System.out.println("result = " + result);
            return ResponseEntity.ok().body(result); // 존재하면 1, 존재하지 않으면 0 반환
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("쿠폰ID을 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰 확인 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}