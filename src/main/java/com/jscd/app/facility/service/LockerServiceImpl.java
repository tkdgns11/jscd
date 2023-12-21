package com.jscd.app.facility.service;

import com.jscd.app.facility.dto.LockerDto;
import com.jscd.app.facility.dao.LockerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class LockerServiceImpl implements LockerService {

    @Autowired
    private LockerDao lockerDao;

    //관리자 락커리스트 페이지
    @Override
    public List<LockerDto> adminGetLockers() { return lockerDao.adminSelectLockers(); }

    @Override
    public List<LockerDto> getAllLockers() {
        return lockerDao.selectAllLockers();
    }

    @Override
    public LockerDto getLocker(String lockerId) {
        return lockerDao.selectLockerById(lockerId);
    }

    //락커 등록
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int registerLocker(String lockerId, LockerDto lockerDto) {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerId);

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 2 ) {

            throw new RuntimeException("등록할 락커를 다시 확인해주세요.");
        }
        return lockerDao.insertLocker(lockerDto);
    }

    //락커 삭제
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteLocker(String lockerId, LockerDto lockerDto) {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerId);

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 1 || !(checkLockerDto.getMebrID().equals(lockerDto.getMebrID()))) {

            throw new RuntimeException("삭제할 락커를 다시 확인해주세요.");
        }

        return lockerDao.deleteLocker(lockerId);
    }

    //락커기간 연장
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int extendLocker(String lockerId, LockerDto lockerDto) {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerId);

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 1 || !(checkLockerDto.getMebrID().equals(lockerDto.getMebrID()))) {

            throw new RuntimeException("연장할 락커를 다시 확인해주세요.");
        }

        return lockerDao.updateLockerEndDate(lockerId, lockerDto.getExtdDays());
    }

    //락커 자리이동
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int moveLocker(LockerDto lockerDto, String newLockerId) {
        System.out.println(" 락커이동 " );

        LockerDto newLocker = lockerDao.selectLockerByIdForUpdate(newLockerId);

        if (newLocker == null || newLocker.getStatusCode() != 2) {
            throw new RuntimeException("선택하신 락커로는 이동할 수 없습니다.");
        }

        LockerDto oldLocker = lockerDao.selectLockerByIdForUpdate(lockerDto.getLockerID());

        if (oldLocker == null || oldLocker.getStatusCode() != 1 || !(oldLocker.getMebrID().equals(lockerDto.getMebrID()))) {
            throw new RuntimeException("이동시킬 락커를 다시 확인해주세요.");
        }

        newLocker.setStatusCode(1);
        newLocker.setMebrID(oldLocker.getMebrID());
        newLocker.setStartDate(oldLocker.getStartDate());
        newLocker.setEndDate(oldLocker.getEndDate());

        return lockerDao.insertLocker(newLocker) + lockerDao.deleteLocker(oldLocker.getLockerID());
    }
}