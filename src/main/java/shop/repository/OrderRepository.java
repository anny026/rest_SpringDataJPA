package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import shop.model.entity.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @org.springframework.data.jpa.repository.Query("from Order where userId=:userId")
    Optional<Order> getOrderByUserId(@Param("userId") Long userId);

}


