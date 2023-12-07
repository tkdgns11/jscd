package com.jscd.app.admin.dao;


import com.jscd.app.admin.dto.InstructorInfoDto;
//import com.jscd.app.lecture.bootCamp.dao.BootCampDao;
//import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class InstructorInfoDaoImplTest {

    @Autowired
    InsturctorInfoDao infoDao;

    @Test
    public void insertTest()throws Exception{
        //전체 지우기
        infoDao.deleteAll();
        //인서트
        InstructorInfoDto infoDto = new InstructorInfoDto("01",1,"자바강사입니다",2,100.0f);
        infoDao.insert(infoDto);
        //count
        int rowCnt = infoDao.count();

        System.out.println("rowCnt = " + rowCnt);
    }

    @Test
    public void selectTest()throws Exception{
        //전체 지우기
//        infoDao.deleteAll();
//        //인서트
//        InstructorInfoDto infoDto = new InstructorInfoDto("01",1,"자바강사입니다",2,100.0f);
//        InstructorInfoDto infoDto2 = new InstructorInfoDto("02",2,"자바강사입니다",2,100.0f);
//        infoDao.insert(infoDto);
//        infoDao.insert(infoDto2);
//        int rowCnt = infoDao.count();
//        System.out.println("rowCnt = " + rowCnt);
//
//        InstructorMemberInfoDto infoDtoTest = infoDao.select("01");
//        System.out.println("infoDtoTest = " + infoDtoTest);
//
//        List<InstructorMemberInfoDto> list = infoDao.selectAll();
//        System.out.println("list = " + list);


    }

    @Test
    public void deleteTest()throws Exception{
        //전체 지우기
        infoDao.deleteAll();
        //인서트
        InstructorInfoDto infoDto = new InstructorInfoDto("01",1,"자바강사입니다",2,100.0f);
        infoDao.insert(infoDto);
        //count
        int rowCnt = infoDao.count();

        System.out.println("rowCnt = " + rowCnt);

        infoDao.delete(1);
        rowCnt = infoDao.count();
        System.out.println("rowCnt = " + rowCnt);


    }

    @Test
    public void updateTest()throws Exception{

    }


}
