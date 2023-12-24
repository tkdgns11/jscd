package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.dto.DashboardDto;

import java.util.List;

public interface AdminDao {
    int insertAdmin(AdminDto adminDto) throws Exception;

    AdminDto selectAdmin(String id) throws Exception;

    List<AdminDto> selectAllAdmin() throws Exception;

    int updateAdmin(AdminDto adminDto) throws Exception;

    int deleteAdmin(String id) throws Exception;

    void deleteAllAdmin() throws Exception;
    int countAdmin()throws Exception;
    int countAssistant() throws Exception;

    // 대시보드
    //1.회원현황 - 전체 회원 수, 일반 회원 수(1), 학생 수(2), 강사 수(3), 관리자 수(4)
    DashboardDto countMemberStatus() throws Exception;
    //2.학원매출 - 부트캠프 매출, 세미나 매출
    DashboardDto totalSalesStatus() throws Exception;
    //3.강의현황 - 진행 중 부트캠프, 진행 예정 부트캠프, 진행 중 세미나, 진행 예정 세미나, 종료 강의
    DashboardDto lstRegistStatus() throws Exception;
    //4.qna(전체) 게시글 카테고리 분류 - 부트캠프 게시글 수, 세미나 게시글 수, 결제 및 환불 게시글 수, 사이트 이용 게시글 수, 학원 관련 게시글 수, 기타 게시글 수
    DashboardDto qnaCategoryStatus() throws Exception;

}
