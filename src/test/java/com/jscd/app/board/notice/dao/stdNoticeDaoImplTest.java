package com.jscd.app.board.notice.dao;

import com.jscd.app.board.notice.dto.stdNoticeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class stdNoticeDaoImplTest {

    @Autowired
    stdNoticeDao stdNoticeDao;


    @Test
    public void deleteTest() throws Exception {

        stdNoticeDao.deleteAll();
        assertTrue(stdNoticeDao.count()==0);
    }



    @Test
    public void insertTestData() throws Exception{

        for (int i=1; i<=500; i++){
            stdNoticeDto stdNoticeDto = new stdNoticeDto("title"+i, "no content", "memeber"+i);
            stdNoticeDao.insert(stdNoticeDto);
        }

    }

}