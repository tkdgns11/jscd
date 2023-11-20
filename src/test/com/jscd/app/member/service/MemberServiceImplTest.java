package com.jscd.app.member.service;

import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberServiceImplTest {

    @Autowired
    MemberService memberService;
    Calendar cal;

    @Before
    public void init(){
        cal =  Calendar.getInstance();
        cal.clear();
        cal.set(2022,01,01);
        LocalDate now = LocalDate.now();
    }

    @Test
    public void login() {
    }

    @Test
    public void logout() {
    }

    @Test
    public void signUp() throws Exception {

//        (id, name, alias, birth, pwd, phone1, phone2, phone3,
//                acct, status, grade, regDate, frsidNmbr, modifyDate, lstidNmbr, etc)
        MemberDto user = new MemberDto("test", "test01", "aaa", "930203", "1234","010","2222","3333","환불계좌번호",0,0,new Date(cal.getTimeInMillis()),"0000",new Date(),"0000","etc");
        memberService.signUp(user);
    }

    @Test
    public void memberInfoEdit() throws Exception {

//      MemberDto user = new MemberDto("test", "test01", "aaa", "930203", "1234","010","2222","3333","환불계좌번호",0,0,new Date(cal.getTimeInMillis()),"0000",new Date(),"0000","etc");
        MemberDto user = new MemberDto();
        user.setId("test");
        user.setAlias("aaaEdit");
        user.setEtc("변경 적용");
        memberService.memberInfoEdit(user);
    }

    @Test
    public void memberDelete() throws Exception {

        MemberDto user = new MemberDto("DeleteTest", "DeleteTest01", "aaa", "930203", "1234","010","2222","3333","환불계좌번호",0,0,new Date(cal.getTimeInMillis()),"0000",new Date(),"0000","etc");
        Assert.assertTrue(memberService.signUp(user)==1);
        memberService.memberDelete(user.getId());

    }
}