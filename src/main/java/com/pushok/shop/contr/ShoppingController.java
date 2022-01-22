package com.pushok.shop.contr;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ShoppingController {

    @PostMapping("/addcart/{id}")
    public void addCart(@PathVariable Long id){

    }



    @GetMapping("/cart")
    public String shoppingCart(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userService.findByName(auth.getName());
        model.addAttribute("products", user.getProducts());
        return "cart";
    }
}
