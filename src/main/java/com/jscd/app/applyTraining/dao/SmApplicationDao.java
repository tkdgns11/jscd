package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.SmApplicationDto;

import java.util.List;
import java.util.Map;

public interface SmApplicationDao {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer stfmNo) throws Exception;

    List<SmApplicationDto> selectAll() throws Exception;

    SmApplicationDto select(Integer stfmNo) throws Exception;

    List<SmApplicationDto> selectPage(Map map) throws Exception;

    int update(SmApplicationDto dto) throws Exception;

    int insert(SmApplicationDto dto) throws Exception;
}
