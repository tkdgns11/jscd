package com.jscd.app.order.service;

import com.jscd.app.order.dao.OrderDao;
import com.jscd.app.order.dto.OrderDTO;
import com.siot.IamportRestClient.IamportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class OrderService {
    private final OrderDao orderDao;

    String apiKey = "3330047733053520"; //REST API Key를 입력합니다.
    String secretKey = "co6BIVvbEgIR4ptnV9aynDwUMXHLjikPsWM0Ib3Fjo69df1onk2bNQLfBsjOpwTzxeuxTGkQxaXtJbLa"; //REST API Secret를 입력합니다.

    @Bean
    public IamportClient iamportClient() {
        return new IamportClient(apiKey, secretKey);
    }

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderDTO getOrder(int registCode) {
        return orderDao.getOrder(registCode);
    }
}
