package com.jscd.app.facility.dao;

import com.jscd.app.facility.dto.LockerDto;

import java.util.List;

public interface LockerDao {

    List<LockerDto> adminSelectLockers();

    List<LockerDto> selectAllLockers();

    LockerDto selectLockerById(String lockerId);

    LockerDto selectLockerByIdForUpdate(String lockerId);

    // 새로운 락커 등록
    int insertLocker(LockerDto lockerDto);

    // 락커 기간 연장
    int updateLockerEndDate(String lockerId, Integer extendDays);

    // 락커 삭제
    int deleteLocker(String lockerId);

    int countActiveLockers();

    int countAllLockers();

    int countFloor4Lockers();

    int countFloor5Lockers();

    List<LockerDto> listActiveLockers();

    int countActiveFloor4Lockers();

    int countActiveFloor5Lockers();

    int countUnusedFloor4Lockers();

    int countUnusedFloor5Lockers();

    List<LockerDto> lockersExpiringIn3Days();

    List<String> membersWithLockersExpiringIn3Days();
}
