package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.dto.DashboardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    SqlSession session;

    private final String namespace = "com.jscd.app.mapper.adminMapper.";

    @Override
    public int insertAdmin(AdminDto adminDto) throws Exception {
        return session.insert(namespace + "insertAdmin", adminDto);
    }

    public int countAdmin() throws Exception {
        return session.selectOne(namespace + "countAdmin");
    }

    public int countAssistant() throws Exception {
        return session.selectOne(namespace + "countAssistant");
    }

    @Override
    public AdminDto selectAdmin(String id) throws Exception {
        return session.selectOne(namespace + "selectAdmin", id);
    }

    @Override
    public List<AdminDto> selectAllAdmin() throws Exception {
        return session.selectList(namespace + "selectAllAdmin");
    }

    @Override
    public int updateAdmin(AdminDto adminDto) throws Exception {
        return session.update(namespace + "updateAdmin", adminDto);
    }

    @Override
    public int deleteAdmin(String id) throws Exception {
        return session.delete(namespace + "deleteAdmin", id);
    }

    @Override
    public void deleteAllAdmin() throws Exception {
        session.delete(namespace + "deleteAllAdmin");
    }



    // 대시보드
    //1.회원현황 - 전체 회원 수, 일반 회원 수(1), 학생 수(2), 강사 수(3), 관리자 수(4)
    public DashboardDto countMemberStatus() throws Exception{
        return session.selectOne(namespace+"countMemberStatus");
    }
    //2.학원매출 - 부트캠프 매출, 세미나 매출
    @Override
    public DashboardDto totalSalesStatus() throws Exception {
        return session.selectOne(namespace+"totalSalesStatus");
    }
    //3.강의현황 - 진행 중 부트캠프, 진행 예정 부트캠프, 진행 중 세미나, 진행 예정 세미나, 종료 강의
    @Override
    public DashboardDto lstRegistStatus() throws Exception {
        return session.selectOne(namespace+"lstRegistStatus");
    }

    //4.qna(전체) 게시글 카테고리 분류 - 부트캠프 게시글 수, 세미나 게시글 수, 결제 및 환불 게시글 수, 사이트 이용 게시글 수, 학원 관련 게시글 수, 기타 게시글 수
    @Override
    public DashboardDto qnaCategoryStatus() throws Exception {
        return  session.selectOne(namespace+"qnaCategoryStatus");
    }


}
