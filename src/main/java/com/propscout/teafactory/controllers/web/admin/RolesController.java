package com.propscout.teafactory.controllers.web.admin;

import com.propscout.teafactory.models.entities.Role;
import com.propscout.teafactory.services.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/roles")
public class RolesController {

    //Logger
    private Logger logger = LoggerFactory.getLogger(RolesController.class);

    //Service Instance
    private RolesService rolesService;

    //Get app title from the properties files
    @Value("${app.title}")
    private String app;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public String index(Model model) {

        List<Role> roles = rolesService.getAllRoles();

        logger.info(roles.toString());

        model.addAttribute("title", "Admin Roles");
        model.addAttribute("roles", roles);
        model.addAttribute("app", app);

        return "admin/roles/index";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("title", "Admin Create Role");
        model.addAttribute("app", app);

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
