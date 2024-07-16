package shop.mapper;

import org.mapstruct.Mapper;
import shop.dto.OrderDto;
import shop.dto.OrderGoodDto;
import shop.model.entity.Order;
import shop.model.entity.OrderGood;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderGoodMapper {
    public OrderGoodDto toDto(OrderGood orderGood);
    public OrderGood fromDto(OrderGoodDto orderGoodDto);
    public List<OrderGoodDto> toDto(List<OrderGood> orderGoods);
}
