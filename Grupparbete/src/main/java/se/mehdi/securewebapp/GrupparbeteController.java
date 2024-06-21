package se.mehdi.securewebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        redirectAttributes.addFlashAttribute("success", "Registration successful!");
        return "redirect:/register";
    }

    @GetMapping("/register/success")
    public String registerSuccess() {
        return "registerSuccess";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("success", "User deleted successfully!");
        return "redirect:/admin";
    }

    @GetMapping("/profile")
    public String userProfile(Model model, Authentication authentication) {
        String username = authentication.getName();
        AppUser user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(Authentication authentication, RedirectAttributes redirectAttributes) {
        String username = authentication.getName();
        AppUser user = userService.findByUsername(username);
        userService.deleteUser(user.getId());
        redirectAttributes.addFlashAttribute("success", "Your account has been deleted.");
        return "redirect:/login";
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
