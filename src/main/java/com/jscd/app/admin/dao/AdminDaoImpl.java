package com.jscd.app.admin.dao;

import com.jscd.app.admin.dto.AdminDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    SqlSession session;

    private final String namespace = "com.jscd.app.mapper.adminMapper.";

    @Override
    public int insertAdmin(AdminDto adminDto) throws Exception {
        return session.insert(namespace + "insertAdmin", adminDto);
    }

    public int countAdmin() throws Exception {
        return session.selectOne(namespace + "countAdmin");
    }

    @Override
    public AdminDto selectAdmin(String id) throws Exception {
        return session.selectOne(namespace + "selectAdmin", id);
    }

    @Override
    public List<AdminDto> selectAllAdmin() throws Exception {
        return session.selectList(namespace + "selectAllAdmin");
    }

    @Override
    public int updateAdmin(AdminDto adminDto) throws Exception {
        return session.update(namespace + "updateAdmin", adminDto);
    }

    @Override
    public int deleteAdmin(String id) throws Exception {
        return session.delete(namespace + "deleteAdmin", id);
    }

    @Override
    public void deleteAllAdmin() throws Exception {
        session.delete(namespace + "deleteAllAdmin");
    }


}
