package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.OrderDto;
import shop.dto.UserDto;
import shop.mapper.OrderMapper;
import shop.mapper.UserMapper;
import shop.model.entity.Order;
import shop.model.entity.User;
import shop.repository.OrderRepository;
import shop.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    public void addOrder(UserDto userDto, Integer price) {
        User user = userMapper.fromDto(userDto);
        if (!orderRepository.getOrderByUserId(user.getId()).isPresent()) {
            orderRepository.save(new Order(user.getId(), price));
        } else {
            Order order = orderRepository.getOrderByUserId(user.getId()).get();
            Float total_price_new = order.getTotalPrice() + price;
            order.setTotalPrice(total_price_new);
            orderRepository.save(order);
        }
    }

    public OrderDto findOrderByIdUser(Long id) {
        return orderMapper.toDto(orderRepository.getOrderByUserId(id).get());
    }


}
