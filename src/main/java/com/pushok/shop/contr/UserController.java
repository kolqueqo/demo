package com.pushok.shop.contr;


import com.pushok.shop.entity.User;
import com.pushok.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//мразь
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserRepo userRepo;

    @RequestMapping
    public String login(){
        User user = new User("fdghfgh", "dfghdfh");
        userRepo.saveAndFlush(user);
        return "login";
    }


}
