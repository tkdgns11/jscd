package com.jscd.app.admin.dao;


import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberManageDaoImplTest {

    @Autowired
    MemberManageDao manageDao;

    @Autowired
    MemberDao memberDao;

    @Test
    public void insertTest()throws Exception{

    manageDao.deleteAll();
    MemberDto memberDto = new MemberDto("asdf","홍길동","1234");
    MemberDto memberDto2 = new MemberDto("asdf2","홍길동","1234");
    MemberDto memberDto3 = new MemberDto("asdf3","홍길동","1234");
    memberDao.insertUser(memberDto);
    memberDao.insertUser(memberDto2);
    memberDao.insertUser(memberDto3);
    int rowCnt = manageDao.count();
        System.out.println("rowCnt = " + rowCnt); //1
        System.out.println("memberDto = " + memberDto);
        System.out.println("memberDto = " + memberDto2);


    }

    @Test
    public void selectTest()throws Exception{



    }

    @Test
    public void deleteTest()throws Exception{

    }

    @Test
    public void updateTest()throws Exception{

    }

}
