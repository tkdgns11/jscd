package com.jscd.app.admin.service;

import com.jscd.app.admin.dto.AdminDto;

import java.util.List;

public interface AdminService {
    int writeAdmin(AdminDto adminDto) throws Exception;

    AdminDto readAdmin(String id) throws Exception;

    List<AdminDto> getListAdmin() throws Exception;

    int modifyAdmin(AdminDto adminDto) throws Exception;

    int removeAdmin(String id) throws Exception;
    int getCountAdmin()throws Exception;
}
