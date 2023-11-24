package com.jscd.app.admin.service;

import com.jscd.app.admin.dao.MemberManageDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberManageServiceImpl implements MemberManageService { //회원관리

    @Autowired
    MemberManageDao manageDao;

    @Override
    public int getCount()throws Exception{
        return manageDao.count();
    }

    @Override
    public List<MemberDto> getList(int offset, int pageSize)throws Exception{
        return manageDao.selectAll(offset, pageSize);
    }

    @Override
    public MemberDto read(Integer mebrNo)throws Exception{
        return manageDao.select(mebrNo);
    }

    @Override
    public int modify(MemberDto memberDto)throws Exception{
        return manageDao.update(memberDto);
    }
    @Override
    public int modifyDetail(MemberDto memberDto)throws Exception{
        return manageDao.updateDetail(memberDto);
    }
    @Override
    public int remove(Integer mebrNo)throws Exception{
        return manageDao.delete(mebrNo);
    }
    @Override
    public List<MemberDto> getSearchPage(SearchCondition sc)throws Exception{
        return manageDao.searchSelectPage(sc);
    }
    @Override
    public int getSearchResultCnt(SearchCondition sc)throws Exception{
        return manageDao.searchResultCnt(sc);
    }

}
