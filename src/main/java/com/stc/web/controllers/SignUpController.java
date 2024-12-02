package com.stc.web.controllers;


import com.stc.web.dto.AccountDto;
import com.stc.web.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reg")
@RequiredArgsConstructor
public class SignUpController {

    private final AccountService accountService;

    @GetMapping
    public String signUp(Model model) {
        model.addAttribute("accountDto",new AccountDto());
        return "signUp";
    }


    @PostMapping
    public String signUp(@Valid AccountDto accountDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        accountService.signUp(accountDto);
        return "redirect:/profile";
    }

}
