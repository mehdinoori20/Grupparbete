package se.mehdi.securewebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GrupparbeteController {


    @GetMapping("/")
    public String loggedIn(){
        return "loggedIn";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/logged-out")
    public String loggedOut(){
        return "loggedOut";
    }
}
