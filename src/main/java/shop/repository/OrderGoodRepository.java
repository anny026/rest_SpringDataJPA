package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import shop.model.entity.Order;
import shop.model.entity.OrderGood;

import java.util.List;

public interface OrderGoodRepository extends CrudRepository<OrderGood, Long> {
    @org.springframework.data.jpa.repository.Query("from OrderGood where order=:order")
    List<OrderGood> getOrderedGoods(@Param("order")Order order);

}




