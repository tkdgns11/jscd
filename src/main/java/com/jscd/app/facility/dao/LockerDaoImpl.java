package com.jscd.app.facility.dao;

import com.jscd.app.facility.dto.LockerDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
    public List<LockerDto> selectAllLockers() {
        return sqlSession.selectList(namespace + "selectAllLockers");
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
    public int updateLockerEndDate(String lockerId, Integer extendDays) {
        Map<String, Object> params = new HashMap<>();
        params.put("lockerId", lockerId);
        params.put("extendDays", extendDays);
        return sqlSession.update(namespace + "updateLockerEndDate", params);
    }

    @Override
    public int deleteLocker(String lockerId) {
        return sqlSession.update(namespace + "deleteLocker", lockerId);
    }

    @Override
    public int countActiveLockers() {
        return sqlSession.selectOne(namespace + "countActiveLockers");
    }

    @Override
    public int countAllLockers() {
        return sqlSession.selectOne(namespace + "countAllLockers");
    }

    @Override
    public int countFloor4Lockers() {
        return sqlSession.selectOne(namespace + "countFloor4Lockers");
    }

    @Override
    public int countFloor5Lockers() {
        return sqlSession.selectOne(namespace + "countFloor5Lockers");
    }

    @Override
    public List<LockerDto> listActiveLockers() {
        return sqlSession.selectList(namespace + "listActiveLockers");
    }

    @Override
    public int countActiveFloor4Lockers() {
        return sqlSession.selectOne(namespace + "countActiveFloor4Lockers");
    }

    @Override
    public int countActiveFloor5Lockers() {
        return sqlSession.selectOne(namespace + "countActiveFloor5Lockers");
    }

    @Override
    public int countUnusedFloor4Lockers() {
        return sqlSession.selectOne(namespace + "countUnusedFloor4Lockers");
    }

    @Override
    public int countUnusedFloor5Lockers() {
        return sqlSession.selectOne(namespace + "countUnusedFloor5Lockers");
    }

    @Override
    public List<LockerDto> lockersExpiringIn3Days() {
        return sqlSession.selectList(namespace + "lockersExpiringIn3Days");
    }

    @Override
    public List<String> membersWithLockersExpiringIn3Days() {
        return sqlSession.selectList(namespace + "membersWithLockersExpiringIn3Days");
    }

}