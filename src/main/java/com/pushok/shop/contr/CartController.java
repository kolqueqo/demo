package com.pushok.shop.contr;


import com.pushok.shop.service.OrderService;
import com.pushok.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/increment/{id}")
    public String increment(@PathVariable Long id){
        userService.inc(id);
        return "redirect:/shopping_cart";
    }

    @PostMapping("/decrement/{id}")
    public String decrement(@PathVariable Long id){
        userService.dec(id);
        return "redirect:/shopping_cart";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.del(id);
        return "redirect:/shopping_cart";
    }

    @PostMapping("/placeOrder")
    public String PlaceOrder(@RequestParam String address){
        orderService.createOrder(address);
        return "redirect:/";
    }
}