package com.pushok.shop.repo;

import com.pushok.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    List<Product> findAllByColor(String color);
    List<Product> findAllByBreed(String breed);

}
