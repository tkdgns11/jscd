package com.jscd.app.facility.service;

import com.jscd.app.facility.dto.LockerDto;
import com.jscd.app.facility.dao.LockerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LockerServiceImpl implements LockerService {

    @Autowired
    private LockerDao lockerDao;

    //관리자 락커리스트 페이지
    @Override
    public List<LockerDto> adminGetLockers() { return lockerDao.adminSelectLockers(); }

    @Override
    public LockerDto getLocker(String lockerId) {
        return lockerDao.selectLockerById(lockerId);
    }

    int count = 0 ;

    //락커 등록
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int registerLocker(LockerDto lockerDto) throws Exception {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerDto.getLockerID());

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 2 ) {

            throw new RuntimeException("등록할 락커를 다시 확인해주세요.");
        }

        checkLockerDto.setMebrID(lockerDto.getMebrID());
        checkLockerDto.setEndDate(lockerDto.getEndDate());
        checkLockerDto.setStatusCode(1);
        checkLockerDto.setEtc("락커 신규 등록");

        return lockerDao.insertLocker(checkLockerDto);
    }

    //락커 자리이동
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int moveLocker(LockerDto lockerDto, String newLockerId) {

        LockerDto newLocker = lockerDao.selectLockerByIdForUpdate(newLockerId);

        System.out.println("newLocker = " + newLocker);

        //고장중인 락커로 옮길경우
        if (newLocker == null || newLocker.getStatusCode() == 3) {
            throw new RuntimeException("선택하신 락커로는 이동할 수 없습니다.");
        }

        LockerDto oldLocker = lockerDao.selectLockerByIdForUpdate(lockerDto.getLockerID());

        System.out.println("oldLocker = " + oldLocker);

        if (oldLocker == null || oldLocker.getStatusCode() != 1 || !(oldLocker.getMebrID().equals(lockerDto.getMebrID()))) {
            throw new RuntimeException("이동시킬 락커를 다시 확인해주세요.");
        }
        //빈자리로 옮기는 경우
        if (newLocker == null || newLocker.getStatusCode() == 2) {

            //oldlocker는 락커삭제.
            oldLocker.setEtc("자리이동으로 인한 기존 락커 삭제");
            count = lockerDao.deleteLocker(oldLocker);

            //newlocker는 old락커에서 정보 가져와서 추가.
            newLocker.setStatusCode(1);
            newLocker.setMebrID(oldLocker.getMebrID());
            newLocker.setStartDate(oldLocker.getStartDate());
            newLocker.setEndDate(oldLocker.getEndDate());
            newLocker.setEtc("자리 이동. 옮길 락커로 등록");

            return count += lockerDao.insertMoveLocker(newLocker);

        } else {
            //사용중인 락커랑 옮기는 경우

            //양쪽 락커에 반대편 사용자, 시작일, 종료일 insert

            String tmpMebrID = newLocker.getMebrID();
            Date tmpStartDate = newLocker.getStartDate();
            Date tmpEndDate = newLocker.getEndDate();

            newLocker.setEtc("양방향 락커 자리이동 " + oldLocker.getLockerID() + "와 자리이동");
            newLocker.setMebrID(oldLocker.getMebrID());
            newLocker.setStartDate(oldLocker.getStartDate());
            newLocker.setEndDate(oldLocker.getEndDate());

            count = lockerDao.insertMoveLocker(newLocker);

            oldLocker.setEtc("양방향 락커 자리이동 " + newLockerId +"와 자리이동" );
            oldLocker.setMebrID(tmpMebrID);
            oldLocker.setStartDate(tmpStartDate);
            oldLocker.setEndDate(tmpEndDate);

            return count += lockerDao.insertMoveLocker(oldLocker);
        }
    }

   //락커 삭제
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteLocker(String lockerId, LockerDto lockerDto) {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerId);

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 1 || !(checkLockerDto.getMebrID().equals(lockerDto.getMebrID()))) {

            throw new RuntimeException("삭제할 락커를 다시 확인해주세요.");
        }

        checkLockerDto.setEtc("사용기간 종료 전 락커 삭제");
        count = lockerDao.insertForEndingUsage(checkLockerDto);
        checkLockerDto.setEtc("사용기간 종료 전 락커 삭제 후 사용안함으로 세팅");
        return count += lockerDao.deleteLocker(checkLockerDto);
    }

    //락커기간 연장
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int extendLocker(String lockerId, LockerDto lockerDto) {
        LockerDto checkLockerDto = lockerDao.selectLockerByIdForUpdate(lockerId);

        if (checkLockerDto == null || checkLockerDto.getStatusCode() != 1 || !(checkLockerDto.getMebrID().equals(lockerDto.getMebrID()))) {

            throw new RuntimeException("연장할 락커를 다시 확인해주세요.");
        }

        int extdDays = lockerDto.getExtdDays();

        checkLockerDto.setEtc("사용기간 " + extdDays + "일 연장" );
        checkLockerDto.setExtdDays(extdDays);

        System.out.println("checkLockerDto = " + checkLockerDto);

        return lockerDao.insertExtendsLocker(checkLockerDto);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> lockerAlert() throws Exception {
        return lockerDao.selectAlert();
    }

    //기간 만료된 락커들 전부 가져와서 삭제
    @Override
    public void deleteExpiredLockers() throws Exception {

        List<LockerDto> expiredLockers = lockerDao.selectExpiredLockers();

        for (LockerDto locker : expiredLockers) {
            lockerDao.deleteLocker(locker);
        }
    }
}