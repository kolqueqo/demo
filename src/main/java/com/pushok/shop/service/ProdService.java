package com.pushok.shop.service;


import com.pushok.shop.entity.Product;
import com.pushok.shop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdService {

    @Autowired
    private ProductRepo productRepo;

    public Product findById(Long id ){
        return productRepo.findById(id).get();
    }


}
