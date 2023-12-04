//package com.jscd.app.lecture.seminar.dao;
//
//import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;
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
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class SeminarRegistDaoImplTest {
//    @Autowired
//    private SeminarRegistDao seminarRegistDao;
//
//    @Test
//    public void count() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//    }
//
//    @Test
//    public void deleteAll() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//
//        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
//        String writer = seminarRegistDao.selectAll().get(0).getWriter();
//        assertTrue(seminarRegistDao.delete(classEnrollNo, writer)==1);
//    }
//
//    @Test
//    public void insert() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//    }
//
//    @Test
//    public void selectAll() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//
//        List<SeminarRegistDto> list = seminarRegistDao.selectAll();
//        System.out.println("list = " + list);
//        assertTrue(list.size()!=0);
//    }
//
//    @Test
//    public void select() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//
//        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
//        dto.setClassEnrollNo(classEnrollNo);
//
//        dto = seminarRegistDao.select(classEnrollNo);
//        SeminarRegistDto dto2 = seminarRegistDao.select(classEnrollNo);
//        assertTrue(dto.getClassEnrollNo().equals(dto2.getClassEnrollNo()));
//        assertTrue(dto.equals(dto2));
//
//        System.out.println("dto = " + dto);
//        System.out.println("dto2 = " + dto2);
//    }
//
//    @Test
//    public void selectPage() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        for(int i=1; i<=10; i++){
//            SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차" + i, "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                    "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                    "20231104", "20231104", "10:00", "13:00", "남궁성",
//                    "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                    "비고", "첨부파일 경로", "castello", "01", "01", 1);
//            seminarRegistDao.insert(dto);
//        }
//
//        Map map = new HashMap();
//        map.put("offset", 0);
//        map.put("pageSize", 3);
//
//        List<SeminarRegistDto> list = seminarRegistDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("세미나 자바의 정석(기초) 1회차10"));
//        assertTrue(list.get(1).getTitle().equals("세미나 자바의 정석(기초) 1회차9"));
//        assertTrue(list.get(2).getTitle().equals("세미나 자바의 정석(기초) 1회차8"));
//
//        map = new HashMap();
//        map.put("offset", 3);
//        map.put("pageSize", 3);
//
//        list = seminarRegistDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("세미나 자바의 정석(기초) 1회차7"));
//        assertTrue(list.get(1).getTitle().equals("세미나 자바의 정석(기초) 1회차6"));
//        assertTrue(list.get(2).getTitle().equals("세미나 자바의 정석(기초) 1회차5"));
//
//        map = new HashMap();
//        map.put("offset", 6);
//        map.put("pageSize", 3);
//
//        list = seminarRegistDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("세미나 자바의 정석(기초) 1회차4"));
//        assertTrue(list.get(1).getTitle().equals("세미나 자바의 정석(기초) 1회차3"));
//        assertTrue(list.get(2).getTitle().equals("세미나 자바의 정석(기초) 1회차2"));
//
//        map = new HashMap();
//        map.put("offset", 9);
//        map.put("pageSize", 3);
//
//        list = seminarRegistDao.selectPage(map);
//        assertTrue(list.get(0).getTitle().equals("세미나 자바의 정석(기초) 1회차1"));
//    }
//
//    @Test
//    public void update() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//
//        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
//        dto.setClassEnrollNo(classEnrollNo);
//        dto.setTitle("수정된 4회차 DB 모델링");
//
//        String title = seminarRegistDao.selectAll().get(0).getTitle();
//        assertTrue(seminarRegistDao.update(dto)==1);
//        String title2 = seminarRegistDao.selectAll().get(0).getTitle();
//        assertTrue(!title.equals(title2));
//
//        System.out.println("title = " + title);
//        System.out.println("title2 = " + title2);
//    }
//
//    @Test
//    public void increaseViewCnt() throws Exception {
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//
//        SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
//                "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
//                "20231104", "20231104", "10:00", "13:00", "남궁성",
//                "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
//                "비고", "첨부파일 경로", "castello", "01", "01", 1);
//        assertTrue(seminarRegistDao.insert(dto)==1);
//
//        Integer classEnrollNo = seminarRegistDao.selectAll().get(0).getClassEnrollNo();
//
//        for(int i=1; i<=10; i++){
//            assertTrue(seminarRegistDao.increaseViewCnt(classEnrollNo)==1);
//            dto = seminarRegistDao.select(classEnrollNo);
//            int viewCnt = dto.getViewCnt();
//            assertTrue(dto.getViewCnt()==i);
//            System.out.println("viewCnt = " + viewCnt);
//        }
//
//        seminarRegistDao.deleteAll();
//        assertTrue(seminarRegistDao.count()==0);
//    }
//
////    @Test
////    public void searchSelectPage()throws Exception{
////        seminarRegistDao.deleteAll();
////        assertTrue(seminarRegistDao.count()==0);
////
////        for(int i=1; i<=20; i++){
////            SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) 1회차" + i, "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
////                    "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
////                    "20231104", "20231104", "10:00", "13:00", "남궁성",
////                    "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
////                    "비고", "첨부파일 경로", "castello", "01", "01", 1);
////            seminarRegistDao.insert(dto);
////        }
////
////        SeminarRegistSearch ss = new SeminarRegistSearch(1, 10, "세미나 자바의 정석(기초) 1회차2", "T");
////        List<SeminarRegistDto> list = seminarRegistDao.searchSelectPage(ss);
////        System.out.println("list = " + list);
////        assertTrue(list.size()==2);
////    }
////    @Test
////    public void searchResultCnt()throws Exception{
////        seminarRegistDao.deleteAll();
////        assertTrue(seminarRegistDao.count()==0);
////
////        for(int i=1; i<=20; i++){
////            SeminarRegistDto dto = new SeminarRegistDto("세미나 자바의 정석(기초) " + i + "회차", "강의 상세 설명입니다.", "자바의 정석(기초)", "1회차", "오프라인",
////                    "종료", "서울시 종로구 종로 서울 YMCA 빌딩 425호", 5, 30, 5,
////                    "20231104", "20231104", "10:00", "13:00", "남궁성",
////                    "자바의 정석", "개인 노트북, 필기구, 교재", 100000, "50%", 50000,
////                    "비고", "첨부파일 경로", "castello", "01", "01", 1);
////            seminarRegistDao.insert(dto);
////        }
////
////        SeminarRegistSearch ss = new SeminarRegistSearch(1, 10, "세미나 자바의 정석(기초) 2", "T");
////        int cnt = seminarRegistDao.searchResultCnt(ss);
////        System.out.println("cnt = " + cnt);
////        assertTrue(cnt==2);
////    }
//} // SeminarRegistDaoImplTest