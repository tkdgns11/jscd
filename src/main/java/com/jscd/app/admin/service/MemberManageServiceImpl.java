package com.jscd.app.admin.service;

import com.jscd.app.admin.dao.AdminDao;
import com.jscd.app.admin.dao.InsturctorInfoDao;
import com.jscd.app.admin.dao.MemberManageDao;
import com.jscd.app.admin.dao.StdManageDao;
import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.MemberManageDto;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberManageServiceImpl implements MemberManageService { //회원 정보 관리

    @Autowired
    MemberManageDao manageDao;

    //회원 등급 변경 시, 필요한 Dao(조교(관리자),강사,학생)
    @Autowired
    InsturctorInfoDao insturctorInfoDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    StdManageDao stdManageDao;

    @Override
    public int getCount() throws Exception {
        return manageDao.count();
    }

    @Override
    public List<MemberDto> getList(int offset, int pageSize) throws Exception {
        return manageDao.selectAll(offset, pageSize);
    }

    @Override
    public MemberManageDto read(Integer mebrNo) throws Exception {
        return manageDao.select(mebrNo);
    }


    @Override
    @Transactional(rollbackFor = Exception.class) //메인페이지 상태/등급 일괄 수정
    public int modify(Integer status, Integer grade, List<Integer> mebrNo) throws Exception {
        int rowCnt = manageDao.update(status, grade, mebrNo);

        //등급이 강사로 변경됐다면,
        if (grade == 3) {
            //회원 정보를 강사테이블로 insert
            InstructorInfoDto instructorInfoDto = new InstructorInfoDto();

            for (int i = 0; i < mebrNo.size(); i++) {
                //회원 번호만 insert(소개말,급여는 추후에 강사가 기입 and 관리자가 지정)
                instructorInfoDto.setMebrNo(mebrNo.get(i));
                rowCnt = insturctorInfoDao.insert(instructorInfoDto);
            }
        } else if (grade == 4) { //등급이 관리자(조교)로 변경됐다면,

            for (int i = 0; i < mebrNo.size(); i++) {
                MemberDto memberDto = manageDao.selectMember(mebrNo.get(i));
                //회원 정보가 관리자 테이블로 insert
                AdminDto adminDto = new AdminDto();
                adminDto.setId(memberDto.getId());
                adminDto.setName(memberDto.getName());
                adminDto.setPwd(memberDto.getPwd());
                rowCnt = adminDao.insertAdmin(adminDto);
            }
        } else if (grade == 2) { //등급이 학생으로 변경됐다면,
            StdManageDto stdManageDto = new StdManageDto();
            for (int i = 0; i < mebrNo.size(); i++) {
                stdManageDto.setMebrNo(mebrNo.get(i)); //회원 번호만 넣기
                stdManageDto.setGisu(""); //기수 어떻게 들어갈지..일단 비우기
                stdManageDto.setStatus(1); //1 '수강예정' 기본값
                rowCnt = stdManageDao.insert(stdManageDto);
            }

        }

        return rowCnt;

    }


    @Override
    @Transactional(rollbackFor = Exception.class) //상세페이지 수정
    public int modifyDetail(MemberDto memberDto) throws Exception {
        int rowCnt = manageDao.updateDetail(memberDto);
        //만약 등급이 강사로 변경됐다면,
        if (memberDto.getGrade() == 3) {
            //멤버의 정보 그대로 강사테이블로 insert
            InstructorInfoDto instructorInfoDto = new InstructorInfoDto();
            instructorInfoDto.setMebrNo(memberDto.getMebrNo());
            insturctorInfoDao.insert(instructorInfoDto);
        } else if (memberDto.getGrade() == 4) { //등급이 관리자로 변경됐다면,
            //멤버의 정보가 관리자 테이블로 insert
            AdminDto adminDto = new AdminDto();
            adminDto.setId(memberDto.getId());
            adminDto.setName(memberDto.getName());
            adminDto.setPwd(memberDto.getPwd());
            adminDao.insertAdmin(adminDto);
        }else if(memberDto.getGrade() == 2){ //학생으로 변경됐다면,
            StdManageDto stdManageDto = new StdManageDto();
            stdManageDto.setMebrNo(memberDto.getMebrNo());
            stdManageDto.setGisu("");
            stdManageDto.setStatus(1); //'수강예정' 기본값
            rowCnt = stdManageDao.insert(stdManageDto);
        }
        return rowCnt;
    }

    @Override
    public int remove(Integer mebrNo) throws Exception {
        return manageDao.delete(mebrNo);
    }

    @Override
    public List<MemberManageDto> getSearchPage(SearchCondition sc) throws Exception {
        return manageDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return manageDao.searchResultCnt(sc);
    }

}
