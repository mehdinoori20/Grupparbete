/*
Info om GrupparbeteController, @Controller säger att denna klass hanterar HTTP requests och @RequestMapping mappar alla requests med paths som vi själva sätter.

vi injecserar en userService med hjälp av @Autowired

@GetMapping sätter upp en endpoint åt oss det metoden retunerar visas på denna endpoint. i vårat fall retunerar vi olika htlm sidor.

RegisterForm metoden tar in en "model" det man kan säga är att på denna endpoint skapar vi en ny AppUser som vi sedan kan lagra i våran databas


 */
package se.mehdi.securewebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.mehdi.securewebapp.entity.AppUser;
import se.mehdi.securewebapp.service.UserService;

@Controller
@RequestMapping("/")
public class GrupparbeteController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loggedIn() {
        return "loggedIn";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(AppUser user, RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addAttribute("success", true);
        return "redirect:/register";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "loggedIn";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/logged-out")
    public String loggedOut() {
        return "loggedOut";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDenied";
    }
}
