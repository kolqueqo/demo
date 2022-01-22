package com.pushok.shop.service;


import com.pushok.shop.entity.Cart;
import com.pushok.shop.entity.Product;
import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.repo.CartRepo;
import com.pushok.shop.repo.ProductRepo;
import com.pushok.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity findByName(String username){
        return userRepo.findUserEntityByUsername(username);
    }

    @Transactional
    public void save(String username, String password, String mail){
        UserEntity user = new UserEntity(mail, username,password,"USER");
        userRepo.saveAndFlush(user);
    }

}
