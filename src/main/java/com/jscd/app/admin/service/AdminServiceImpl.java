package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.AdminDao;
import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService { //관리자

    @Autowired
    AdminDao adminDao;

    @Override
    public int writeAdmin(AdminDto adminDto) throws Exception {
        return adminDao.insertAdmin(adminDto);
    }

    @Override
    public AdminDto readAdmin(String id) throws Exception {
        return adminDao.selectAdmin(id);
    }

    @Override
    public List<AdminDto> getListAdmin() throws Exception {
        return adminDao.selectAllAdmin();
    }

    @Override
    public int modifyAdmin(AdminDto adminDto) throws Exception {
        return adminDao.updateAdmin(adminDto);
    }

    @Override
    public int removeAdmin(String id) throws Exception {
        return adminDao.deleteAdmin(id);
    }

    @Override
    public int getCountAdmin() throws Exception {
        return adminDao.countAdmin();
    }

    @Override
    public int getCountAssistant() throws Exception {
        return adminDao.countAssistant();
    }


    // 대시보드
    //1.회원현황 - 전체 회원 수, 일반 회원 수(1), 학생 수(2), 강사 수(3), 관리자 수(4)
    public DashboardDto memberStatus( ) throws Exception{
        return adminDao.countMemberStatus();
    }
    //2.학원매출 - 부트캠프 매출, 세미나 매출
    @Override
    public DashboardDto salesStatus() throws Exception {
        return adminDao.totalSalesStatus();
    }
    //3.강의현황 - 진행 중 부트캠프, 진행 예정 부트캠프, 진행 중 세미나, 진행 예정 세미나, 종료 강의
    @Override
    public DashboardDto lstRegistStatus() throws Exception {
        return adminDao.lstRegistStatus();
    }
    //4.qna(전체) 게시글 카테고리 분류 - 부트캠프 게시글 수, 세미나 게시글 수, 결제 및 환불 게시글 수, 사이트 이용 게시글 수, 학원 관련 게시글 수, 기타 게시글 수
    @Override
    public DashboardDto qnaCategoryStatus() throws Exception {
        return adminDao.qnaCategoryStatus();
    }

}