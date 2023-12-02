package com.jscd.app.lecture.round.dao;

import com.jscd.app.lecture.round.dto.RoundDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoundDaoImpl implements RoundDao  {
    @Autowired
    SqlSession session;
    private static String namespace = "com.jscd.app.lecture.round.roundMapper.";
    @Override
    public List<RoundDto> getRoundList() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int addRound(RoundDto dto) throws Exception {
        return session.insert(namespace + "addRound", dto);
    }

    @Override
    public RoundDto readRound(Integer roundCode) throws Exception {
        return session.selectOne(namespace + "readRound", roundCode);
    }

    @Override
    public int removeRound(Integer roundCode) throws Exception {
        return session.delete(namespace + "removeRound", roundCode);
    }

    @Override
    public int modifyRound(RoundDto dto) throws Exception {
        return session.update(namespace + "modifyRound", dto);
    }
}
