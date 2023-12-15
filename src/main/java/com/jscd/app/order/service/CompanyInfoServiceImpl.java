package com.jscd.app.order.service;

import com.jscd.app.order.dao.CompanyInfoDao;
import com.jscd.app.order.dto.CompanyInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoDao companyInfoDao;

    @Override
    public CompanyInfoDTO select(int slrNo) {
        System.out.println("service company");
        return companyInfoDao.select(slrNo);
    }
}
