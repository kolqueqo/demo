package com.pushok.shop.repo;

import com.pushok.shop.entity.Cart;
import com.pushok.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {


    Cart findByProductAndUserId(Product product, Long userId);

    void deleteAllByUserId(Long id);

}
