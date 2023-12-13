package com.jscd.app.board.notice.dao;

import com.jscd.app.board.notice.dto.noticeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class noticeDaoImplTest {

    @Autowired
    noticeDao noticeDao;


    @Test
    public void countTest() throws Exception {

        noticeDao.deleteAll();
        assertTrue(noticeDao.count()==0);
    }

    @Test
    public void insertTest() throws Exception {

        noticeDao.deleteAll();
       // noticeDto noticeDto = new noticeDto("no title", "no content", "asdf");
       // assertTrue(noticeDao.insert(noticeDto)==1);
        //assertTrue(noticeDao.count()==1);
    }

    @Test
    public void insertTestData() throws Exception{

        for (int i=1; i<=500; i++){
            noticeDto noticeDto = new noticeDto("title"+i, "no content", "memeber"+i);
            noticeDao.insert(noticeDto);
        }

    }

}