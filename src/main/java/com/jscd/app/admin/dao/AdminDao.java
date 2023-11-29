package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.AdminDto;

import java.util.List;

public interface AdminDao {
    int insertAdmin(AdminDto adminDto) throws Exception;

    AdminDto selectAdmin(String id) throws Exception;

    List<AdminDto> selectAllAdmin() throws Exception;

    int updateAdmin(AdminDto adminDto) throws Exception;

    int deleteAdmin(String id) throws Exception;

    void deleteAllAdmin() throws Exception;
    int countAdmin()throws Exception;
}
