package shop.service;

import shop.model.entity.Order;
import shop.model.entity.User;

public interface OrderService {
    public void addOrder(User e, Integer price);

    public Order findOrderByIdUser(Long id);
}
