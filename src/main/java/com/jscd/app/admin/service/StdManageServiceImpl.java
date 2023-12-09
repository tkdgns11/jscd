package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.MemberManageDao;
import com.jscd.app.admin.dao.StdManageDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StdManageServiceImpl implements StdManageService { //학생 정보 관리
    @Autowired
    StdManageDao stdManageDao;

    @Autowired
    MemberManageDao memberManageDao;

    @Override
    public int write(StdManageDto stdManageDto) throws Exception {
        return stdManageDao.insert(stdManageDto);
    }

    @Override
    public int getCount() throws Exception {
        return stdManageDao.count();
    }

    @Override
    public List<StdMemberManageDto> getList(int offset, int pageSize) throws Exception {
        return stdManageDao.selectAll(offset, pageSize);
    }

    @Override
    public StdMemberManageDto read(Integer mebrNo) throws Exception {
        return stdManageDao.select(mebrNo);
    }

    @Override //실행 완료
    @Transactional(rollbackFor = Exception.class)
    public int modify(StdManageDto stdManageDto) throws Exception { //메인 화면 수정
        //상태가 변경
        int rowCnt = stdManageDao.update(stdManageDto);

        //만약에, 상태가 '수료'라면,
        if (stdManageDto.getStatus() == 3) {
            MemberDto memberDto = memberManageDao.selectMember(stdManageDto.getMebrNo());
            //등급을 일반으로 변경한다
            memberDto.setGrade(1);
            rowCnt = memberManageDao.updateDetail(memberDto);
        }
        return rowCnt;
    }

    @Override //실행 완료
    @Transactional(rollbackFor = Exception.class)
    public int modifyStatus(Integer status, List<Integer> mebrNo) throws Exception { //상세 보기 수정
        //상태를 변경
        int rowCnt = stdManageDao.updateStatus(status, mebrNo);
        //만약에, 상태가 '수료'라면,
        if (status == 3) {
            for (int i = 0; i < mebrNo.size(); i++) {

                MemberDto memberDto = memberManageDao.selectMember(mebrNo.get(i));
                memberDto.setGrade(1);
                rowCnt = memberManageDao.updateDetail(memberDto);
            }
        }
        return rowCnt;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer mebrNo) throws Exception {    //상세보기)수료를 하지 못하고 삭제 시, 회원의 등급이 일반으로 변경
        //학생 테이블에서 삭제
        int rowCnt = stdManageDao.delete(mebrNo);

        //회원의 등급이 일반으로 업데이트
        MemberDto memberDto = memberManageDao.selectMember(mebrNo);
        memberDto.setGrade(1);
        rowCnt = memberManageDao.updateDetail(memberDto);

        return rowCnt;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeMain(List<Integer> mebrNo) throws Exception {     //메인화면)수료를 하지 못하고 삭제 시, 회원의 등급이 일반으로 변경
        //학생 테이블에서 삭제
        int rowCnt = stdManageDao.deleteMain(mebrNo);

        for (int i = 0; i < mebrNo.size(); i++) {

            //회원의 등급이 일반으로 업데이트
            MemberDto memberDto = memberManageDao.selectMember(mebrNo.get(i));
            memberDto.setGrade(1);
            rowCnt = memberManageDao.updateDetail(memberDto);
        }

        return rowCnt;
    }

    @Override
    public List<StdMemberManageDto> getSearchPage(SearchCondition sc) throws Exception {
        return stdManageDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return stdManageDao.searchResultCnt(sc);
    }


}
