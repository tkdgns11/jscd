package com.jscd.app.admin.dao;


import com.jscd.app.admin.dto.StdManageDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class StdManageDaoImplTest {

    @Autowired
    StdManageDao stdManageDao;

    @Test
    public void insertTest()throws Exception{
        stdManageDao.deleteAll();
        StdManageDto stdManageDto = new StdManageDto(1,1010,"7기","수강중");
        StdManageDto stdManageDto2 = new StdManageDto(3,1010,"7기","수강중");
        stdManageDao.insert(stdManageDto);
        stdManageDao.insert(stdManageDto2);

        int rowCnt = stdManageDao.count();
        System.out.println("rowCnt = " + rowCnt); //1

    }

    @Test
    public void selectTest()throws Exception{
        stdManageDao.deleteAll();
        StdManageDto stdManageDto = new StdManageDto(1,1010,"7기","수강중");
        StdManageDto stdManageDto2 = new StdManageDto(3,1010,"7기","수강중");
        stdManageDao.insert(stdManageDto);
        stdManageDao.insert(stdManageDto2);

        StdMemberManageDto stdMemberManageDto = stdManageDao.select(3);
        System.out.println("stdMemberManageDto = " + stdMemberManageDto);

        List<StdMemberManageDto> list = stdManageDao.selectAll();
        System.out.println("list = " + list);

    }

    @Test
    public void deleteTest()throws Exception{

        stdManageDao.deleteAll();

        StdManageDto stdManageDto = new StdManageDto(1,1010,"7기","수강중");
        StdManageDto stdManageDto2 = new StdManageDto(3,1010,"7기","수강중");
        stdManageDao.insert(stdManageDto);
        stdManageDao.insert(stdManageDto2);

        int rowCnt = stdManageDao.count();
        System.out.println("rowCnt = " + rowCnt); //2

        stdManageDao.delete(3);
        rowCnt = stdManageDao.count();
        System.out.println("rowCnt = " + rowCnt); //1




    }

    @Test
    public void updateTest()throws Exception{

    }



}
