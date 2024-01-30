package com.jscd.app.facility.dao;

import com.jscd.app.facility.dto.LockerDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LockerDaoImpl implements LockerDao {

    @Autowired
    private final SqlSession sqlSession;

    @Autowired
    private static final String namespace = "com.jscd.app.facility.LockerMapper.";

    public LockerDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<LockerDto> adminSelectLockers() {
        return sqlSession.selectList(namespace + "adminSelectLockers");
    }

    @Override
    public List<LockerDto> mebrSelectLockers() {
        return sqlSession.selectList(namespace + "mebrSelectLockers");
    }

    @Override
    public List<LockerDto> selectAllLockers() {
        return sqlSession.selectList(namespace + "selectAllLockers");
    }

    @Override
    public List<LockerDto> SelectMebrIDLockers(String mebrID) {
        return sqlSession.selectList(namespace + "SelectMebrLockers",mebrID);
    }

    @Override
    public List<LockerDto> selectExpiredLockers() {
        return sqlSession.selectList(namespace + "selectExpiredLockers");
    }

    @Override
    public LockerDto selectLockerById(String lockerId) {
        return sqlSession.selectOne(namespace + "selectLockerById", lockerId);
    }

    @Override
    public LockerDto selectLockerByIdForUpdate(String lockerId) {
        return sqlSession.selectOne(namespace + "selectLockerByIdForUpdate", lockerId);
    }

    @Override
    public int insertLocker(LockerDto lockerDto) {
        return sqlSession.insert(namespace + "insertLocker", lockerDto);
    }

    @Override
    public int insertMoveLocker(LockerDto lockerDto) {
        return sqlSession.insert(namespace + "insertMoveLocker", lockerDto);
    }

    @Override
    public int insertForEndingUsage(LockerDto lockerDto) {
        return sqlSession.insert(namespace + "insertForEndingUsage", lockerDto);
    }

    @Override
    public int deleteLocker(LockerDto lockerDto) {
        lockerDto.setStatusCode(2);
        return sqlSession.update(namespace + "deleteLocker", lockerDto);
    }

    @Override
    public int insertExtendsLocker(LockerDto lockerDto) {
        return sqlSession.insert(namespace + "insertExtendsLocker", lockerDto);
    }

    @Override
    public List<Map<String, Object>> selectAlert() throws Exception {
        return sqlSession.selectList(namespace + "selectAlert");
    }
}