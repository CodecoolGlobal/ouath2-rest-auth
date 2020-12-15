package com.raczkowski.springintro.util;

import com.raczkowski.springintro.dto.OrderDto;
import com.raczkowski.springintro.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDtoToOrderConverter {

    public Order convert(OrderDto orderDto) {
        return new Order(orderDto.getId(),
                orderDto.getProduct(),
                orderDto.getTotalPrice());
    }

    public List<Order> convertAll(List<OrderDto> orderDtos) {
        return orderDtos.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
