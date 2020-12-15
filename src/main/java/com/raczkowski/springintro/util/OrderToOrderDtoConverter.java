package com.raczkowski.springintro.util;

import com.raczkowski.springintro.dto.OrderDto;
import com.raczkowski.springintro.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class OrderToOrderDtoConverter {

    public OrderDto convert(Order order) {
        return new OrderDto(
                order.getId(),
                order.getProduct(),
                order.getTotalPrice());
    }

    public List<OrderDto> convertAll(List<Order> orders) {
        return orders.stream()
                .map(this::convert)
                .collect(toList());
    }

}
