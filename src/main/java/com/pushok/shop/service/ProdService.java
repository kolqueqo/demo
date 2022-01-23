package com.pushok.shop.service;


import com.pushok.shop.entity.Product;
import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdService {

    @Autowired
    private ProductRepo productRepo;

    public Product findById(Long id ){
        return productRepo.findById(id).get();
    }

    @Transactional
    public void save(String breed, String color, Double price){
        Product product = new Product(breed, color, price);
        productRepo.saveAndFlush(product);
    }
}
