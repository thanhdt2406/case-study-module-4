package com.codegym.casestudy4.service.orderDetail;

import com.codegym.casestudy4.model.OrderDetail;
import com.codegym.casestudy4.service.IGeneralService;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    Iterable<OrderDetail> findAllByOrdered(Long id);
}
