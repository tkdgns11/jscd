package com.jscd.app.facility.service;

import com.jscd.app.facility.dto.LockerDto;
import java.util.List;
import java.util.Map;

public interface LockerService {

    List<Map<String, Object>> lockerAlert() throws Exception;

    List<LockerDto> adminGetLockers();

    List<LockerDto> getAllLockers();

    LockerDto getLocker(String lockerId);

    int registerLocker(String lockerId, LockerDto lockerDto);

    int extendLocker(String lockerId, LockerDto lockerDto);

    int moveLocker(LockerDto oldLocker, String newLockerId);

    int deleteLocker(String lockerId, LockerDto lockerDto);

    int deleteExpiredLockers() throws Exception;
}
