package com.pd.pd_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/error")
    public String errorPage(Model model)
    {
        // На самом деле, этот кусок не работает. Хорошо бы это как-то поправить, а то противно получается :(
        System.out.println("Мы где-то в error логе");
        return "error";
    }
    @GetMapping("/")
    public String homePage(Model model)
    {
        return "homepage";
    }
    @GetMapping({"/web", "/web/"})
    public String webHomePage(Model model)
    {
        return "homepage";
    }
}
