package com.stc.web.controllers;


import com.stc.web.config.AccountUserDetails;
import com.stc.web.models.account.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {


    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        Account account = userDetails.getAccount();

        model.addAttribute("email", account.getEmail());
        model.addAttribute("name", account.getName());
        model.addAttribute("surname", account.getSurname());
        model.addAttribute("phone", account.getPhone());
        model.addAttribute("role", account.getRole().name());

        return "profile";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }


}
