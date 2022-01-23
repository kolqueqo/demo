package com.pushok.shop.service;


import com.pushok.shop.entity.Cart;
import com.pushok.shop.entity.Product;
import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.repo.CartRepo;
import com.pushok.shop.repo.ProductRepo;
import com.pushok.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepo cartRepo;

    public UserEntity findByName(String username){
        return userRepo.findUserEntityByUsername(username);
    }

    @Transactional
    public void save(String username, String password, String mail){
        UserEntity user = new UserEntity(mail, username,password,"USER");
        userRepo.saveAndFlush(user);
    }

    @Transactional
    public void addProduct(Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        Product product = productRepo.findById(id).get();
        Cart cart = cartRepo.findByProductAndUserId(product, user.getId());

        if(cart != null){
            cart.inc();
            cartRepo.saveAndFlush(cart);
            return;
        }
        else{
            cart = new Cart(1,product, user.getId());
        }

        cartRepo.saveAndFlush(cart);
        user.addProduct(cart);
        userRepo.saveAndFlush(user);

    }

    @Transactional
    public void inc(Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        Product product = productRepo.findById(id).get();
        Cart cart = cartRepo.findByProductAndUserId(product, user.getId());
        cart.inc();

        cartRepo.saveAndFlush(cart);
    }

    @Transactional
    public void dec(Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        Product product = productRepo.findById(id).get();
        Cart cart = cartRepo.findByProductAndUserId(product, user.getId());
        cart.dec();

        cartRepo.saveAndFlush(cart);
    }

    @Transactional
    public void del(Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        Product product = productRepo.findById(id).get();
        Cart cart = cartRepo.findByProductAndUserId(product, user.getId());

        user.deleteProduct(cart);
        cartRepo.delete(cart);
        userRepo.saveAndFlush(user);
    }

    @Transactional
    public void delALL(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        user.del();
        userRepo.saveAndFlush(user);
        cartRepo.deleteAllByUserId(user.getId());
    }
}
