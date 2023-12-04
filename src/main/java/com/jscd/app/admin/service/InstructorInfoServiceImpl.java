package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.InsturctorInfoDao;
import com.jscd.app.admin.dao.MemberManageDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorInfoServiceImpl implements InstructorInfoService { //강사 정보 관리

    @Autowired
    InsturctorInfoDao infoDao;

    @Autowired
    MemberManageDao memberManageDao;

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

    @Override //실행 완
    @Transactional(rollbackFor = Exception.class)
    public int modify(InstructorInfoDto instructorInfoDto) throws Exception {
        int rowCnt = infoDao.update(instructorInfoDto);

        //만약, 상태를 퇴직으로 변경한다면
        if (instructorInfoDto.getStatus() == 4) {
            MemberDto memberDto = memberManageDao.selectMember(instructorInfoDto.getMebrNo());
            //등급을 일반으로 변경한다
            memberDto.setGrade(1);
            rowCnt = memberManageDao.updateDetail(memberDto);
        }

        return rowCnt;
    }

    @Override//실행 완
    @Transactional(rollbackFor = Exception.class)
    public int modifyStatus(Integer status, List<Integer> mebrNo) throws Exception {
        int rowCnt = infoDao.updateStatus(status, mebrNo);
        if (status == 4) {
            for (int i = 0; i < mebrNo.size(); i++) {
                MemberDto memberDto = memberManageDao.selectMember(mebrNo.get(i));
                memberDto.setGrade(1);
                rowCnt = memberManageDao.updateDetail(memberDto);
            }
        }
        return rowCnt;

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
