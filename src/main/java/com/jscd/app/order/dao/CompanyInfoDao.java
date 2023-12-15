package com.jscd.app.order.dao;

import com.jscd.app.order.dto.CompanyInfoDTO;

public interface CompanyInfoDao {
    CompanyInfoDTO select(int slrNo);
}
