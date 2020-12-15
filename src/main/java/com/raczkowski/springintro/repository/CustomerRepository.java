package com.raczkowski.springintro.repository;

import com.raczkowski.springintro.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
