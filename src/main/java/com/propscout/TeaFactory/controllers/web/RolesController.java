package com.propscout.TeaFactory.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/roles")
public class RolesController {

    @GetMapping
    public String index() {
        return "admin/roles/index";
    }
}
