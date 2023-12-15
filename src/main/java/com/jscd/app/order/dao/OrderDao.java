package com.jscd.app.order.dao;

import com.jscd.app.order.dto.OrderDTO;

public interface OrderDao {
    OrderDTO getOrder(int registCode);
}
