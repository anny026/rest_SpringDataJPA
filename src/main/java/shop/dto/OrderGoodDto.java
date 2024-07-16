package shop.dto;

import jakarta.persistence.*;
import shop.model.entity.Good;
import shop.model.entity.Order;

public class OrderGoodDto {

    private Long id;

    private Order order;

    private Good good;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return " "+good;
    }
}
