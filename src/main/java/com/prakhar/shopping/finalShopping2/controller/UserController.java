package com.prakhar.shopping.finalShopping2.controller;

import com.prakhar.shopping.finalShopping2.entity.User;
import com.prakhar.shopping.finalShopping2.repository.UserRepo;
import com.prakhar.shopping.finalShopping2.security.SecurityService;
import com.prakhar.shopping.finalShopping2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@EnableAutoConfiguration
@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    User user;

    @Autowired
    private UserService userService;



    @Autowired
    private PasswordEncoder encoder;

    public UserController() {
    }

    @GetMapping("/")
    public String showLoginPage(){
        return "login";

    }
    @PostMapping("/login")
    public String login(String email, String password){

        boolean loginresponse = securityService.login(email, password);
        if (loginresponse){
            return "redirect:index";
        }
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/regForm")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registrationUser";
    }

    @PostMapping("/registration")
    public  String register(@Valid User user, BindingResult result){

        if(result.hasErrors()){
            //return "errorPage";
            return "registrationUser";
        }
        if(userService.findByEmail(user)){
             //new UserNameAlreadyExists("User Already Exists WIth this UserNAme");
            return "errorPage";

        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }
    @GetMapping("/errorPage")
    public String error(){
        return "errorPage";
    }

}
