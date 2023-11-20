package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;

import java.util.List;

public interface InsturctorInfoDao {
    int insert(InstructorInfoDto instructorInfoDto) throws Exception;

    List<InstructorMemberInfoDto> selectAll() throws Exception;

    InstructorMemberInfoDto select(String iscrNo) throws Exception;

    int update(InstructorInfoDto instructorInfoDto) throws Exception;

    int delete(Integer mebrNo) throws Exception;

    void deleteAll() throws Exception;
    int count()throws Exception;
}
