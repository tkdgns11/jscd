package com.jscd.app.member.service;

import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberServiceImplTest {

    @Autowired
    MemberDao memberDao;

    @Test
    public void loginCheck() {
    }

    @Test
    public void logout() {
    }

    @Test
    public void signUp() throws Exception {
        MemberDto user = new MemberDto();
//        (mebrNo, id, name, alias, birth, pwd, phone1, phone2, phone3,
//                acct, status, grade, regDate, frsidNmbr, modifyDate, lstidNmbr, etc)
        user.setId("asdf");
        user.setName("재경");
        user.setPwd("1234");

        System.out.println( memberDao.insertUser(user));
    }
}