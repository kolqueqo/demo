package com.pushok.shop.contr;


import com.pushok.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthorizationController {



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @RequestMapping("/loginka")
    public String loginka(){
        return "login";
    }


    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String getReg(String username, String mail, String password, Model model){
        System.out.println(username);
        if (userService.findByName(username) != null) {
            model.addAttribute("message", "ты по-моему чето перепутал");
            return "registration";
        }
        userService.save(username,passwordEncoder.encode(password),mail);
        return "redirect:loginka";
    }

}
