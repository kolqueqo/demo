package com.pushok.shop.contr;


import com.pushok.shop.entity.UserEntity;
import com.pushok.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ShoppingController {


    @Autowired
    private UserService userService;


    @PostMapping("/addcart/{id}")
    public String addCart(@PathVariable Long id){
        userService.addProduct(id);
        return "redirect:/";
    }



    @GetMapping("/cart")
    public String shoppingCart(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userService.findByName(auth.getName());
        model.addAttribute("products", user.getProducts());
        return "cart";
    }
}
