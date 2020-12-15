package com.raczkowski.springintro.util;

import com.raczkowski.springintro.dto.CustomerDto;
import com.raczkowski.springintro.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
public class CustomerDtoToCustomerConverter {

    private OrderDtoToOrderConverter orderConverter;

    public CustomerDtoToCustomerConverter(OrderDtoToOrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    public Customer convert(CustomerDto customerDto) {
        return new Customer(customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getRegistrationDate(),
                customerDto.getOrders() != null ? orderConverter.convertAll(customerDto.getOrders()) : emptyList());
    }

    public List<Customer> convertAll(List<CustomerDto> customerDtos) {
        return customerDtos.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
