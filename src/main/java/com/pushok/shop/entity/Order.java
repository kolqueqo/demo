package com.pushok.shop.entity;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_cart_clone")
    private List<CartClown> cart_clone;

    private String adress;


    public void addProd(CartClown c){
        cart_clone.add(c);
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartClown> getProducts() {
        return cart_clone;
    }

    public void setProducts(List<CartClown> cart_clone) {
        this.cart_clone = cart_clone;
    }

    public Order(List<CartClown> cart_clone, String adress) {
        this.cart_clone = cart_clone;
        this.adress = adress;
    }
}
