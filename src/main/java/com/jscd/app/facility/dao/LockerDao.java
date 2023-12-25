package com.jscd.app.facility.dao;

import com.jscd.app.facility.dto.LockerDto;

import java.util.List;
import java.util.Map;

public interface LockerDao {

    List<LockerDto> adminSelectLockers();

    List<LockerDto> mebrSelectLockers();

    List<LockerDto> selectAllLockers();

    List<LockerDto> SelectMebrIDLockers(String mebrID);

    List<LockerDto> selectExpiredLockers();

    LockerDto selectLockerById(String lockerId);

    LockerDto selectLockerByIdForUpdate(String lockerId);

    //새로운 락커 등록
    int insertLocker(LockerDto lockerDto);

    //자리이동 락커 등록
    int insertMoveLocker(LockerDto lockerDto);

    //사용기간 만료 전 삭제
    int insertForEndingUsage(LockerDto lockerDto);

    // 락커 삭제
    int deleteLocker(LockerDto lockerDto);

    // 락커 기간 연장
    int insertExtendsLocker(LockerDto lockerDto);

    List<Map<String, Object>> selectAlert() throws Exception;

}