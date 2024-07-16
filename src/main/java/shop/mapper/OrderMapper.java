package shop.mapper;

import org.mapstruct.Mapper;
import shop.dto.GoodDto;
import shop.dto.OrderDto;
import shop.model.entity.Good;
import shop.model.entity.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    public OrderDto toDto(Order order);
    public Order fromDto(OrderDto orderDto);
    public List<OrderDto> toDto(List<Order> orders);
}
