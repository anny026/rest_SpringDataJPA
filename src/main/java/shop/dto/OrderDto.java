package shop.dto;

import jakarta.persistence.Column;

public class OrderDto {

    private Long id;

    private Long userId;

    private float totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return         "    " +totalPrice+ " $";
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
