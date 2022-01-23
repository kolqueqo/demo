package com.pushok.shop.service;

import com.pushok.shop.entity.Cart;
import com.pushok.shop.entity.CartClown;
import com.pushok.shop.entity.Order;
import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.repo.CartClownRepo;
import com.pushok.shop.repo.OrderRepo;
import com.pushok.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartClownRepo cartClownRepo;

    @Autowired
    private UserService userService;

    @Transactional
    public void createOrder(String address){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userRepo.findUserEntityByUsername(auth.getName());
        Order order = new Order(new ArrayList<>(), address);
        for (Cart c : user.getProducts()){
            CartClown cartClown = new CartClown(c.getQuantity(),c.getProduct());
            cartClownRepo.saveAndFlush(cartClown);
            order.addProd(cartClown);
        }
        orderRepo.saveAndFlush(order);
        userService.delALL();
    }

    @Transactional
    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }

}
