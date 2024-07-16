package shop.service;

import shop.model.entity.Good;
import shop.model.entity.Order;
import shop.model.entity.OrderGood;
import shop.model.entity.User;

import java.util.Map;

public interface OrderGoodService {
    public void addOrderGood(Good e, User user, Order order, Integer key);

    public Map<Integer, OrderGood> findOrderedGoods(Order order) ;
}
