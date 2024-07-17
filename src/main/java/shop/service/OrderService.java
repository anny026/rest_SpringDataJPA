package shop.service;

import shop.dto.OrderDto;
import shop.dto.UserDto;
import shop.model.entity.Order;
import shop.model.entity.User;

public interface OrderService {
    public void addOrder(UserDto user, Integer price);

    public OrderDto findOrderByIdUser(Long id);
}
