package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.GoodDto;
import shop.dto.OrderDto;
import shop.dto.OrderGoodDto;
import shop.mapper.GoodMapper;
import shop.mapper.OrderGoodMapper;
import shop.mapper.OrderMapper;
import shop.model.entity.OrderGood;
import shop.repository.OrderGoodRepository;
import shop.service.OrderGoodService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderGoodServiceImpl implements OrderGoodService {

    private final OrderGoodRepository orderGoodRepository;
    private final OrderGoodMapper orderGoodMapper;
    private final OrderMapper orderMapper;
    private final GoodMapper goodMapper;

    @Autowired
    public OrderGoodServiceImpl(OrderGoodMapper orderGoodMapper, OrderMapper orderMapper, GoodMapper goodMapper, OrderGoodRepository orderGoodRepository) {
        this.orderGoodMapper = orderGoodMapper;
        this.orderMapper = orderMapper;
        this.orderGoodRepository = orderGoodRepository;
        this.goodMapper = goodMapper;
    }

    public void addOrderGood(GoodDto good, OrderDto order) {
        orderMapper.fromDto(order);
        orderGoodRepository.save(new OrderGood(
                orderMapper.fromDto(order),
                goodMapper.fromDto(good)));
    }

    public Map<Long, OrderGoodDto> findOrderedGoods(OrderDto order) {
        List<OrderGoodDto> goods = orderGoodMapper.toDto(orderGoodRepository
                .getOrderedGoods(orderMapper.fromDto(order)));
        Map<Long, OrderGoodDto> goodsMap = goods.stream()
                .collect(Collectors.toMap(OrderGoodDto::getId, Function.identity()));
        return goodsMap;
    }

}
