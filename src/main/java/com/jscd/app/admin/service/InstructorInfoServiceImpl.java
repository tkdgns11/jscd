package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.InsturctorInfoDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorInfoServiceImpl implements InstructorInfoService { //강사 정보 관리

    @Autowired
    InsturctorInfoDao infoDao;

    @Override
    public int write(InstructorInfoDto instructorInfoDto) throws Exception {
        return infoDao.insert(instructorInfoDto);
    }

    @Override
    public int getCount() throws Exception {
        return infoDao.count();
    }

    @Override
    public List<InstructorMemberInfoDto> getList(int offset, int pageSize) throws Exception {
        return infoDao.selectAll(offset, pageSize);
    }

    @Override
    public InstructorMemberInfoDto read(String iscrNo) throws Exception {
        return infoDao.select(iscrNo);
    }

    @Override
    public int modify(InstructorInfoDto instructorInfoDto) throws Exception {
        return infoDao.update(instructorInfoDto);
    }

    @Override
    public int modifyStatus(Integer status,List<Integer>mebrNo) throws Exception {
        return infoDao.updateStatus(status,mebrNo);
    }


    @Override
    public int remove(Integer mebrNo) throws Exception {
        return infoDao.delete(mebrNo);
    }


    @Override
    public List<InstructorMemberInfoDto> getSearchPage(SearchCondition sc) throws Exception {
        return infoDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return infoDao.searchResultCnt(sc);
    }


}
