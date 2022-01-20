package com.pushok.shop.entity;


import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private int quantity;

    @OneToOne
    private Product product;

    public Cart() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart(Long userId, int quantity, Product product) {
        this.userId = userId;
        this.quantity = quantity;
        this.product = product;
    }
}
