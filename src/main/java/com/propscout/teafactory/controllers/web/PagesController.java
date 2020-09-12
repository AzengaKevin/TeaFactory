package com.propscout.teafactory.controllers.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @Value("${app.title}")
    private String app;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("app", app);
        model.addAttribute("title", "Welcome");

        return "index";
    }
}
