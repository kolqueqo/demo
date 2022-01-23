package com.pushok.shop.entity;


import org.springframework.security.core.parameters.P;

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

    public void inc(){
        quantity++;
    }

    public void dec(){
        if(quantity > 1){
            quantity--;
        }
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

    public Cart( int quantity, Product product, Long userId) {
        this.quantity = quantity;
        this.product = product;
        this.userId = userId;
    }
}
