package com.jscd.app.lecture.round.service;

import com.jscd.app.lecture.round.dao.RoundDao;
import com.jscd.app.lecture.round.dto.RoundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService{
    @Autowired
    RoundDao roundDao;

    @Override
    public List<RoundDto> getRoundList() throws Exception {
        return roundDao.getRoundList();
    }

    @Override
    public int addRound(RoundDto dto) throws Exception {
        return roundDao.addRound(dto);
    }

    @Override
    public RoundDto readRound(Integer roundCode) throws Exception {
        RoundDto roundDto = roundDao.readRound(roundCode);
        return roundDto;
    }

    @Override
    public int removeRound(Integer roundCode) throws Exception {
        return roundDao.removeRound(roundCode);
    }

    @Override
    public int modifyRound(RoundDto dto) throws Exception {
        return roundDao.modifyRound(dto);
    }
}
