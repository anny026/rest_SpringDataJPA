package shop.model.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private float price;

    public Good() {};

    public Good(Long id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<OrderGood> getGoodsInOrders() {
        return goodsInOrders;
    }

    public void setGoodsInOrders(List<OrderGood> goodsInOrders) {
        this.goodsInOrders = goodsInOrders;
    }


    @OneToMany(mappedBy = "good", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderGood> goodsInOrders = new ArrayList<>();

    @Override
    public String toString() {
        return
                "  "+title+" "+ price+ "$";
    }
}
