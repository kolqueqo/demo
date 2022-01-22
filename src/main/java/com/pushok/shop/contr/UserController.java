package com.pushok.shop.contr;


import com.pushok.shop.entity.Product;
import com.pushok.shop.repo.ProductRepo;
import com.pushok.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public ProductRepo productRepo;


    @RequestMapping
    public String login(@RequestParam(value="color" , required = false) String[] color,
                        @RequestParam(value="breed" , required = false)String[] breed, Model model){
        if (color != null || breed != null) {
            HashSet<Product> products = new HashSet<>();
            if (color != null) {
                for (String s : color) {
                    products.addAll(productRepo.findAllByColor(s));
                }
            }
            if (breed != null ) {
                for (String s : breed) {
                    products.addAll(productRepo.findAllByBreed(s));
                }
            }
            model.addAttribute("products", products);
        }
        else {
            model.addAttribute("products",productRepo.findAll());
        }
        return "home_page";
    }


}
