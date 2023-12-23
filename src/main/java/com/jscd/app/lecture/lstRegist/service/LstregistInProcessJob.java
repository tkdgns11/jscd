package com.jscd.app.lecture.lstRegist.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LstregistInProcessJob implements Job {

    @Autowired
    private LstService lstService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("쿼츠 작업 시작: 강의 시작일이 오늘인 강의들 진행중으로 변경");
            // 사용기간 만료된 락커 삭제
           lstService.lstRegistInprocess();
        } catch (Exception e) {
            System.err.println("상태 변경중 에러 발생: " + e.getMessage());
            throw new JobExecutionException(e);
        }
    }
}