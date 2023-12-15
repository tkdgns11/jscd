package com.jscd.app.lecture.classEnroll.service;

import com.jscd.app.lecture.classEnroll.dao.ClassEnrollDao;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEnrollServiceImpl implements ClassEnrollService {
    @Autowired
    ClassEnrollDao classEnrollDao;

    @Override
    public List<ClassEnrollDto> getList(Integer courseCode) throws Exception{
        return classEnrollDao.selectAll(courseCode);
    }

    @Override
    public ClassEnrollDto read(Integer classCode) throws Exception{
        ClassEnrollDto classEnrollDto = classEnrollDao.select(classCode);
        return classEnrollDto;
    }

    @Override
    public int write(ClassEnrollDto dto) throws Exception{
        return classEnrollDao.insert(dto);
    }

    @Override
    public int modify(ClassEnrollDto dto) throws Exception{
        return classEnrollDao.update(dto);
    }

    @Override
    public int remove(Integer classCode) throws Exception{
        return classEnrollDao.delete(classCode);
    }

    //    부트캠프 신청 상세페이지에서 부트캠프 관련 category와 content만 불러오기.
    @Override
    public List<ClassEnrollDto> getBootList(Integer courseCode) throws Exception {
        return classEnrollDao.selectBoot(courseCode);
    }
}
