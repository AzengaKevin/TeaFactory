package com.propscout.teafactory.controllers.web.farmer;

import com.propscout.teafactory.models.entities.Account;
import com.propscout.teafactory.models.entities.User;
import com.propscout.teafactory.services.AccountsService;
import com.propscout.teafactory.services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("farmer/accounts")
public class AccountsController {

    //Logger
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${app.title}")
    private String app;

    private final AccountsService accountsService;
    private final UsersService usersService;

    public AccountsController(AccountsService accountsService, UsersService usersService) {
        this.accountsService = accountsService;
        this.usersService = usersService;
    }

    @GetMapping
    public String index(Principal principal, Model model) {

        if (principal == null) return "redirect:/login";

        //Current logged in users email
        String email = principal.getName();

        Optional<User> optionalLoggedInUser = usersService.getUserByEmail(email);

        optionalLoggedInUser.orElseThrow(() -> new UsernameNotFoundException("Currently logged in users username Not found"));

        model.addAttribute("app", app);
        model.addAttribute("title", "Accounts");
        model.addAttribute("user", optionalLoggedInUser.get());

        return "farmer/accounts/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("app", app);
        model.addAttribute("title", "Create Account");
        model.addAttribute("account", new Account());

        return "farmer/accounts/create";

    }

    @PostMapping
    public String store(@ModelAttribute("account") Account account, Principal principal) {

        //Set the account for this user
        logger.info(principal.getName());

        accountsService.addAccount(account);

        return "redirect:/farmer/accounts";
    }
}
