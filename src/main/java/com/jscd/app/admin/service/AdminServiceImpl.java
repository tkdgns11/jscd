package com.jscd.app.admin.service;


import com.jscd.app.admin.dao.AdminDao;
import com.jscd.app.admin.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService { //관리자

    @Autowired
    AdminDao adminDao;

    @Override
    public int writeAdmin(AdminDto adminDto) throws Exception {
        return adminDao.insertAdmin(adminDto);
    }

    @Override
    public AdminDto readAdmin(String id) throws Exception {
        return adminDao.selectAdmin(id);
    }

    @Override
    public List<AdminDto> getListAdmin() throws Exception {
        return adminDao.selectAllAdmin();
    }

    @Override
    public int modifyAdmin(AdminDto adminDto) throws Exception {
        return adminDao.updateAdmin(adminDto);
    }

    @Override
    public int removeAdmin(String id) throws Exception {
        return adminDao.deleteAdmin(id);
    }

    @Override
    public int getCountAdmin() throws Exception {
        return adminDao.countAdmin();
    }


}
