package com.task.taskManagement.controller;

import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.task.taskManagement.model.User;
import com.task.taskManagement.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository urepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, ModelMap modelMap) {
        List<User> list = urepo.findByEMAIL(user.getUser_email());

        if (!list.isEmpty()) {
            modelMap.addAttribute("error", "Oops! User already exists.");
            modelMap.addAttribute("showSignIn", false); // Stay on sign-up
            return "home";
        } else {
            // Hash the password before saving
            user.setUser_pass(passwordEncoder.encode(user.getUser_pass()));
            urepo.save(user);
            modelMap.addAttribute("message", "User registered successfully.");
            modelMap.addAttribute("showSignIn", true); // Switch to login form
            return "home";
        }
    }

    @PostMapping("/login")
    public String login_user(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             HttpSession session,
                             ModelMap modelMap) {
        List<User> users = urepo.findByEMAIL(email);
        if (!users.isEmpty() && passwordEncoder.matches(password, users.get(0).getUser_pass())) {
            session.setAttribute("username", email);
            return "add";  // Redirect to dashboard or task add page
        } else {
            modelMap.put("error", "Invalid Account");
            modelMap.put("showSignIn", true);
            return "home";
        }
    }


    @GetMapping("/logout")
    public String logout_user(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}