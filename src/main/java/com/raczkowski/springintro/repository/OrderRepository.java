package com.raczkowski.springintro.repository;

import com.raczkowski.springintro.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
