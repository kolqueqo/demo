package com.pushok.shop.entity;

import javax.persistence.*;

@Entity(name = "cart_clone")
public class CartClown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int quantity;

    @OneToOne
    private Product product;

    public CartClown() {
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

    public CartClown( int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
