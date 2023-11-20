//package com.jscd.app.lecture.bootCamp.dao;
//
//import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:/src/main/webbap/WEB-INF/spring/**/root-context.xml"})
//public class BootCampDaoImplTest {
//
//    @Autowired
//    BootCampDao bootCampDao;
//
//    @Test
//    public void insertBootCamp() throws Exception {
//        BootCampDto boot = new BootCampDto();
//        boot.setClassEnrollNo("B0101");
//        boot.setName("부트캠프11기");
//
//        System.out.println("bootCampDao.insertBootCamp(boot) = " + bootCampDao.insertBootCamp(boot));
//    }
//
//}