package com.jscd.app.facility.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LockerDeleteJob implements Job {

    @Autowired
    private LockerService lockerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("쿼츠 작업 시작: 만료된 락커 삭제");
            // 사용기간 만료된 락커 삭제
            int deletedCount = lockerService.deleteExpiredLockers();
            System.out.println("삭제된 락커 수: " + deletedCount);
        } catch (Exception e) {
            System.err.println("만료된 락커 삭제 중 에러 발생: " + e.getMessage());
            throw new JobExecutionException(e);
        }
    }
}
