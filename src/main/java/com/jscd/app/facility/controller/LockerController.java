package com.jscd.app.facility.controller;

import com.jscd.app.admin.service.CouponService;
import com.jscd.app.facility.dto.LockerDto;
import com.jscd.app.facility.dto.LockerUserRequestDto;
import com.jscd.app.facility.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locker")
public class LockerController {

    @Autowired
    LockerService lockerService;

    @Autowired
    CouponService couponService;

    //락커 등록
    @PostMapping("/register")
    public ResponseEntity<?> createLocker(@RequestBody LockerDto lockerDto) {
        System.out.println("lockerDto = " + lockerDto);
        try {
            int result = lockerService.registerLocker(lockerDto);
            if (result == 1) {
                return ResponseEntity.ok().body("락커 등록에 성공했습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 등록에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("등록할 락커를 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    //자리이동
    @PatchMapping("/{newLockerId}/move")
    public ResponseEntity<?> moveLocker(@PathVariable String newLockerId, @RequestBody LockerDto lockerDto) {
        try {
            int result = lockerService.moveLocker(lockerDto, newLockerId);
            if (result == 2) {
                return ResponseEntity.ok("락커 이동이 완료되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 이동에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("락커 정보를 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 이동 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    //락커삭제
    @PatchMapping("/{lockerId}/delete")
    public ResponseEntity<?> deleteLocker(@PathVariable String lockerId, @RequestBody LockerDto lockerDto) {
        try {
            int result = lockerService.deleteLocker(lockerId, lockerDto);
            if (result == 2) {
                return ResponseEntity.ok("락커 삭제가 완료되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 삭제에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제할 락커를 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 삭제 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 관리자에 의한 락커 기간연장
    @PatchMapping("/{lockerId}/extend")
    public ResponseEntity<?> extendLockerByAdmin(@PathVariable String lockerId, @RequestBody LockerDto lockerDto) {
        try {
            int result = lockerService.extendLocker(lockerId, lockerDto);
            if (result == 1) {
                return ResponseEntity.ok("락커 기간이 연장되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 기간 연장에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("연장할 락커를 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 기간 연장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 사용자에 의한 쿠폰을 이용한 락커 기간연장
    @PatchMapping("/{lockerId}/CouponExtend")
    public ResponseEntity<?> extendLockerByUser(@PathVariable String lockerId, @RequestBody LockerUserRequestDto lockerUserRequestDto) {
        try {
            String couponID = lockerUserRequestDto.getCouponID().trim();
            System.out.println("couponID = " + couponID);
            if (couponService.checkCoupon(couponID) != 1) {
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰ID을 다시 확인해주세요.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("쿠폰ID을 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("쿠폰 확인 중 오류가 발생했습니다: " + e.getMessage());
        }

        try {
            LockerDto lockerDto = new LockerDto(lockerUserRequestDto.getLockerID(),lockerUserRequestDto.getMebrID(),lockerUserRequestDto.getStartDate(),lockerUserRequestDto.getEndDate());
            int result = lockerService.extendLocker(lockerId, lockerDto);
            if (result != 1) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 기간 연장에 실패했습니다.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("연장할 락커를 다시 확인해주세요: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 기간 연장 중 오류가 발생했습니다: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("락커 기간 연장에 실패했습니다.");
    }
}