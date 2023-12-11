package com.jscd.app.applyTraining.service;

import com.jscd.app.applyTraining.dto.SmApplicationDto;

import java.util.List;
import java.util.Map;

public interface SmApplicationService {
    int getCount() throws Exception;

    int remove(Integer stfmNo) throws Exception;

    List<SmApplicationDto> getList() throws Exception;

    SmApplicationDto read(Integer stfmNo) throws Exception;

    List<SmApplicationDto> getPage(Map map) throws Exception;

    int modify(SmApplicationDto dto) throws Exception;

    int write(SmApplicationDto dto) throws Exception;

    int lectureApplyInsert(SmApplicationDto dto) throws Exception;
}
