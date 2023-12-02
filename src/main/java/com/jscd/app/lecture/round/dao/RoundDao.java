package com.jscd.app.lecture.round.dao;

import com.jscd.app.lecture.round.dto.RoundDto;

import java.util.List;

public interface RoundDao {
    List<RoundDto> getRoundList() throws Exception;
    int addRound(RoundDto dto) throws Exception;
    RoundDto readRound(Integer roundCode) throws Exception;
    int removeRound(Integer roundCode) throws Exception;
    int modifyRound(RoundDto dto) throws Exception;
}
