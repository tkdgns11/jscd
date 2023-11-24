package com.jscd.app.lecture.seminar.dao;

import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;
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
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SeminarRegistDaoImplTest {
    @Autowired
    private SeminarRegistDao seminarRegistDao;

    @Test
    public void count() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);
    }

    @Test
    public void deleteAll() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);
    }

    @Test
    public void delete() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);

        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
        String writer = seminarRegistDao.selectAll().get(0).getWriter();
        assertTrue(seminarRegistDao.delete(classEnrollNo, writer)==1);
    }

    @Test
    public void insert() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);
        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);
    }

    @Test
    public void selectAll() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);

        List<SeminarRegistDto> list = seminarRegistDao.selectAll();
        System.out.println("list = " + list);
        assertTrue(list.size()!=0);
    }

    @Test
    public void select() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);

        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
        dto.setClassEnrollNo(classEnrollNo);

        dto = seminarRegistDao.select(classEnrollNo);
        SeminarRegistDto dto2 = seminarRegistDao.select(classEnrollNo);
        assertTrue(dto.getClassEnrollNo().equals(dto2.getClassEnrollNo()));
        assertTrue(dto.equals(dto2));

        System.out.println("dto = " + dto);
        System.out.println("dto2 = " + dto2);
    }

    @Test
    public void selectPage() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        for(int i=1; i<=10; i++){
            SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링"+i, "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                    "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                    "20231111", "20231222", "10:00", "20:00", "남궁성",
                    "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                    "비고", "castello", "01", "01", 1);
            seminarRegistDao.insert(dto);
        }

        Map map = new HashMap();
        map.put("offset", 0);
        map.put("pageSize", 3);

        List<SeminarRegistDto> list = seminarRegistDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("4회차 DB 모델링10"));
        assertTrue(list.get(1).getTitle().equals("4회차 DB 모델링9"));
        assertTrue(list.get(2).getTitle().equals("4회차 DB 모델링8"));

        map = new HashMap();
        map.put("offset", 3);
        map.put("pageSize", 3);

        list = seminarRegistDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("4회차 DB 모델링7"));
        assertTrue(list.get(1).getTitle().equals("4회차 DB 모델링6"));
        assertTrue(list.get(2).getTitle().equals("4회차 DB 모델링5"));

        map = new HashMap();
        map.put("offset", 6);
        map.put("pageSize", 3);

        list = seminarRegistDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("4회차 DB 모델링4"));
        assertTrue(list.get(1).getTitle().equals("4회차 DB 모델링3"));
        assertTrue(list.get(2).getTitle().equals("4회차 DB 모델링2"));

        map = new HashMap();
        map.put("offset", 9);
        map.put("pageSize", 3);

        list = seminarRegistDao.selectPage(map);
        assertTrue(list.get(0).getTitle().equals("4회차 DB 모델링1"));
    }

    @Test
    public void update() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);

        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
        dto.setClassEnrollNo(classEnrollNo);
        dto.setTitle("수정된 4회차 DB 모델링");

        String title = seminarRegistDao.selectAll().get(0).getTitle();
        assertTrue(seminarRegistDao.update(dto)==1);
        String title2 = seminarRegistDao.selectAll().get(0).getTitle();
        assertTrue(!title.equals(title2));

        System.out.println("title = " + title);
        System.out.println("title2 = " + title2);
    }

    @Test
    public void increaseViewCnt() throws Exception {
        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);

        SeminarRegistDto dto = new SeminarRegistDto("4회차 DB 모델링", "강의 상세 설명입니다.", "DB 모델링", "4회차", "오프라인",
                "모집중", "서울시 종로구 종로 서울 YMCA 빌딩 522호", 5, 30, 5,
                "20231111", "20231222", "10:00", "20:00", "남궁성",
                "DB 모델링 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
                "비고", "castello", "01", "01", 1);
        assertTrue(seminarRegistDao.insert(dto)==1);

        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();

        for(int i=1; i<=10; i++){
            assertTrue(seminarRegistDao.increaseViewCnt(classEnrollNo)==1);
            dto = seminarRegistDao.select(classEnrollNo);
            int viewCnt = dto.getViewCnt();
            assertTrue(dto.getViewCnt()==i);
            System.out.println("viewCnt = " + viewCnt);
        }

        seminarRegistDao.deleteAll();
        assertTrue(seminarRegistDao.count()==0);
    }
} // SeminarRegistDaoImplTest