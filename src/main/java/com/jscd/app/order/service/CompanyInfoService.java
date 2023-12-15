package com.jscd.app.order.service;

import com.jscd.app.order.dto.CompanyInfoDTO;

public interface CompanyInfoService {
    CompanyInfoDTO select(int slrNo);
}
