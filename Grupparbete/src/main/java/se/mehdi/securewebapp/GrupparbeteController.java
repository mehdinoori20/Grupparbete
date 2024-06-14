package se.mehdi.securewebapp;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.mehdi.securewebapp.web.UserDTO;

@Controller
@RequestMapping
public class GrupparbeteController {


 private final PasswordEncoder passwordEncoder;

 public GrupparbeteController(PasswordEncoder passwordEncoder){
     this.passwordEncoder = passwordEncoder;
 }


    @GetMapping("/")
    public String loggedIn(){
        return "loggedIn";
    }

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("user", new UserDTO());
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
