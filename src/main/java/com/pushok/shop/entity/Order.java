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
    @JoinTable(name = "pepega")
    private List<CartClown> products;

    private String adress;


    public void addProd(CartClown c){
        products.add(c);
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
        return products;
    }

    public void setProducts(List<CartClown> products) {
        this.products = products;
    }

    public Order(List<CartClown> products, String adress) {
        this.products = products;
        this.adress = adress;
    }
}
