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
    public List<ClassEnrollDto> getList() throws Exception{
        return classEnrollDao.selectAll();
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
}
