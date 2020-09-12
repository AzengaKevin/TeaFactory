package com.propscout.teafactory.controllers.web.auth;

import com.propscout.teafactory.models.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Value("${app.title}")
    private String app;

    @GetMapping
    public String showForm(Model model) {

        model.addAttribute("app", app);
        model.addAttribute("title", "Register");
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping
    public String registerUser() {

        return "register";
    }

}
