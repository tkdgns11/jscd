package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.StdManageDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdManageServiceImpl implements StdManageService { //학생관리
    @Autowired
    StdManageDao stdManageDao;

    @Override
    public int write(StdManageDto stdManageDto)throws Exception{
        return stdManageDao.insert(stdManageDto);
    }

    @Override
    public int getCount()throws Exception{
        return stdManageDao.count();
    }

    @Override
    public List<StdMemberManageDto> getList(int offset,int pageSize)throws Exception{
        return stdManageDao.selectAll(offset, pageSize);
    }

    @Override
    public StdMemberManageDto read(Integer mebrNo)throws Exception{
        return stdManageDao.select(mebrNo);
    }

    @Override
    public int modify(StdManageDto stdManageDto)throws Exception{
        return stdManageDao.update(stdManageDto);
    }

    @Override
    public int remove(Integer mebrNo)throws Exception{
        return stdManageDao.delete(mebrNo);
    }

    @Override
    public List<StdMemberManageDto> getSearchPage(SearchCondition sc)throws Exception{
        return stdManageDao.searchSelectPage(sc);
    }
    @Override
    public int getSearchResultCnt(SearchCondition sc)throws Exception{
        return stdManageDao.searchResultCnt(sc);
    }


}
