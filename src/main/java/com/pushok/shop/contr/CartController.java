package com.pushok.shop.contr;


import com.pushok.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private UserService userService;


    @PostMapping("/inc/{id}")
    public String increment(@PathVariable Long id){
        userService.inc(id);
        return "redirect:/cart";
    }

    @PostMapping("/dec/{id}")
    public String decrement(@PathVariable Long id){
        userService.dec(id);
        return "redirect:/cart";
    }

    @PostMapping("/del/{id}")
    public String delete(@PathVariable Long id){
        userService.del(id);
        return "redirect:/cart";
    }
}