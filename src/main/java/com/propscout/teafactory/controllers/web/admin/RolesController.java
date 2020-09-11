package com.propscout.teafactory.controllers.web.admin;

import com.propscout.teafactory.models.entities.Role;
import com.propscout.teafactory.services.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/roles")
public class RolesController {

    Logger logger = LoggerFactory.getLogger(RolesController.class);

    private RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public String index() {
        return "admin/roles/index";
    }

    @GetMapping("create")
    public String create() {
        return "admin/roles/create";
    }

    @PostMapping
    public String store(
            @ModelAttribute final Role newRole,
            final BindingResult bindingResult
    ) {
        if (!bindingResult.hasErrors()) {

            //For debugging
            logger.info(newRole.toString());

            if (rolesService.add(newRole)) {
                return "redirect:/admin/roles";
            }

        }

        return "redirect:/admin/roles/create";
    }
}
