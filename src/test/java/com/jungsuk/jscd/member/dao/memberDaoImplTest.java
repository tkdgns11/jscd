package com.jungsuk.jscd.member.dao;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jscd.app.member.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class memberDaoImplTest {
	
	@Autowired
    MemberDao memberDao;
    Calendar cal;
    
    @Before // 각 테스트가 수행되기 직전에 이 메서드가 실행된다.
    public void init() throws Exception {
       cal = Calendar.getInstance();   
       cal.clear();
       cal.set(2021, 1, 1);

    }


	@Test
	public void insertTest() {
		fail("Not yet implemented");
	}

}
