package com.codegym.casestudy4.service.orderDetail;

import com.codegym.casestudy4.model.OrderDetail;
import com.codegym.casestudy4.repo.IOrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService{
    @Autowired
    private IOrderItemsRepository iOrderItemsRepository;

    @Override
    public Iterable<OrderDetail> findAll() {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return iOrderItemsRepository.save(orderDetail);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Iterable<OrderDetail> findAllByOrdered(Long id) {
        return iOrderItemsRepository.findAllByOrdered_OrderId(id);
    }
}
