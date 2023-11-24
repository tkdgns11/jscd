//package com.jscd.app.lecture.bootCamp.dao;
//
//import com.jscd.app.lecture.bootCamp.dao.BootCampDao;
//import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//// 관리자 고유 번호(FK)값을 어떻게 가져와야할지 모르겠어서
//// 우선 null 가능하게 처리 후 테스트
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class BootCampDaoImplTest {
//    @Autowired
//    private BootCampDao bootCampDao;
//
//    @Test
//    public void count() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//    }
//
//    @Test
//    public void deleteAll() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//
//        Integer classEnrollNo = bootCampDao.selectAll().get(0).getclassEnrollNo();
//        String writer = bootCampDao.selectAll().get(0).getWriter();
//        assertTrue(bootCampDao.delete(classEnrollNo, writer)==1);
//    }
//
//    @Test
//    public void insert() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//    }
//
//    @Test
//    public void selectAll() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//
//        List<BootCampDto> list = bootCampDao.selectAll();
//        System.out.println("list = " + list);
//        assertTrue(list.size()!=0);
//    }
//
//    @Test
//    public void select() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//
//        Integer classEnrollNo = bootCampDao.selectAll().get(0).getclassEnrollNo();
//        dto.setclassEnrollNo(classEnrollNo);
//
//        dto = bootCampDao.select(classEnrollNo);
//        BootCampDto dto2 = bootCampDao.select(classEnrollNo);
//        assertTrue(dto.getclassEnrollNo().equals(dto2.getclassEnrollNo()));
//        assertTrue(dto.equals(dto2));
//
//        System.out.println("dto = " + dto);
//        System.out.println("dto2 = " + dto2);
//    }
//
//    @Test
//    public void selectPage() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//
//        for(int i=1; i<=10; i++){
//            BootCampDto dto = new BootCampDto(
//                    "M0101", "자바의 정석(기초)"+i, "강의 상세 설명", "남궁성", "2023-11-18",
//                    "2023-11-19", "09:00", "11:00", 150000, "종료",
//                    "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                    "개인노트북, 필기구, 교재", "castello", "비고");
//            bootCampDao.insert(dto);
//        }
//
//        Map map = new HashMap();
//        map.put("offset", 0);
//        map.put("pageSize", 3);
//
//        List<BootCampDto> list = bootCampDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("자바의 정석(기초)10"));
//        assertTrue(list.get(1).getTitle().equals("자바의 정석(기초)9"));
//        assertTrue(list.get(2).getTitle().equals("자바의 정석(기초)8"));
//
//        map = new HashMap();
//        map.put("offset", 3);
//        map.put("pageSize", 3);
//
//        list = bootCampDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("자바의 정석(기초)7"));
//        assertTrue(list.get(1).getTitle().equals("자바의 정석(기초)6"));
//        assertTrue(list.get(2).getTitle().equals("자바의 정석(기초)5"));
//
//        map = new HashMap();
//        map.put("offset", 6);
//        map.put("pageSize", 3);
//
//        list = bootCampDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("자바의 정석(기초)4"));
//        assertTrue(list.get(1).getTitle().equals("자바의 정석(기초)3"));
//        assertTrue(list.get(2).getTitle().equals("자바의 정석(기초)2"));
//
//        map = new HashMap();
//        map.put("offset", 9);
//        map.put("pageSize", 3);
//
//        list = bootCampDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("자바의 정석(기초)1"));
//    }
//
//    @Test
//    public void update() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//
//        Integer classEnrollNo = bootCampDao.selectAll().get(0).getclassEnrollNo();
//        dto.setclassEnrollNo(classEnrollNo);
//        dto.setTitle("수정된 자바의 정석(기초)");
//
//        String title = bootCampDao.selectAll().get(0).getTitle();
//        assertTrue(bootCampDao.update(dto)==1);
//        String title2 = bootCampDao.selectAll().get(0).getTitle();
//        assertTrue(!title.equals(title2));
//
//        System.out.println("title = " + title);
//        System.out.println("title2 = " + title2);
//    }
//
//    @Test
//    public void increaseViewCnt() throws Exception {
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//
//        BootCampDto dto = new BootCampDto(
//                "M0101", "자바의 정석(기초)", "강의 상세 설명", "남궁성", "2023-11-18",
//                "2023-11-19", "09:00", "11:00", 150000, "종료",
//                "F", "서울시 종로구 종로 서울 YMCA 빌딩 423호", 5, 30, "자바의 정석",
//                "개인노트북, 필기구, 교재", "castello", "비고");
//        assertTrue(bootCampDao.insert(dto)==1);
//
//        Integer classEnrollNo = bootCampDao.selectAll().get(0).getclassEnrollNo();
//
//        for(int i=1; i<=10; i++){
//            assertTrue(bootCampDao.increaseViewCnt(classEnrollNo)==1);
//            dto = bootCampDao.select(classEnrollNo);
//            int viewCnt = dto.getViewCnt();
//            assertTrue(dto.getViewCnt()==i);
//            System.out.println("viewCnt = " + viewCnt);
//        }
//
//        bootCampDao.deleteAll();
//        assertTrue(bootCampDao.count()==0);
//    }
//} // SeminarRegistDaoImplTest