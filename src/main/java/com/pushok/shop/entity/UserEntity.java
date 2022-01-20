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
    @JoinTable(name = "user_product",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "ID"))
    private List<Cart> products;

    private String role;

    public User() {

    }

    public void addProduct(Cart product){
        this.products.add(product);
    }

    public void deleteProduct(Cart product){
        this.products.remove(product);
    }

    public void deleteAllProduct(){
        this.products.clear();
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

    public User(String email, String username, String password, String role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
