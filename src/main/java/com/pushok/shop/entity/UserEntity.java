package com.pushok.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String email;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_cart",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "ID"))
    private List<Cart> cart;

    private String role;

    public UserEntity() {

    }

    public Long getId() {
        return Id;
    }

    public List<Cart> getProducts() {
        return cart;
    }

    public void del(){
        cart.clear();
    }

    public void setProducts(List<Cart> cart) {
        this.cart = cart;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void addProduct(Cart cart){
        this.cart.add(cart);
    }

    public void deleteProduct(Cart cart){
        this.cart.remove(cart);
    }

    public void deleteAllProduct(){
        this.cart.clear();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserEntity(String email, String username, String password, String role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
