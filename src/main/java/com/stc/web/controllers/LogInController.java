package com.stc.web.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LogInController {


    @GetMapping
    public String getLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error != null){
            model.addAttribute("error", "Неверный email или пароль");
        }
        return "login";
    }

}
