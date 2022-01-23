package com.pushok.shop.contr;

import com.pushok.shop.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class AddController {
    @Autowired
    private ProdService prodService;

    @PostMapping("/product_add")
    public String AddProduct(String breed, String color, Double price){
        prodService.save(breed, color, price);
        return "redirect:/add";
    }
}
