package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderItemsRepository extends CrudRepository<OrderDetail,Long> {
    Iterable<OrderDetail> findAllByOrdered_OrderId(Long id);
}
