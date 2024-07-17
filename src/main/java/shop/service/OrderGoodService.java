package shop.service;

import shop.dto.GoodDto;
import shop.dto.OrderDto;
import shop.dto.OrderGoodDto;
import shop.model.entity.Good;
import shop.model.entity.Order;
import shop.model.entity.OrderGood;
import shop.model.entity.User;

import java.util.Map;

public interface OrderGoodService {
    public void addOrderGood(GoodDto good, OrderDto order);

    public Map<Long, OrderGoodDto> findOrderedGoods(OrderDto order) ;
}
