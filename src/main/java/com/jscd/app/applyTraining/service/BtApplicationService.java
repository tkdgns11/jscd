package com.jscd.app.applyTraining.service;

import com.jscd.app.applyTraining.dto.BtApplicationDto;

import java.util.List;
import java.util.Map;

public interface BtApplicationService {
    int getCount() throws Exception;

    int remove(Integer stfmNo) throws Exception;

    List<BtApplicationDto> getList() throws Exception;

    BtApplicationDto read(Integer stfmNo) throws Exception;

    List<BtApplicationDto> getPage(Map map) throws Exception;

    int modify(BtApplicationDto dto) throws Exception;

    int write(BtApplicationDto dto) throws Exception;

    int lectureApplyInsert(BtApplicationDto dto) throws Exception;
    BtApplicationDto confirmApplcation(Map map) throws Exception;
}
