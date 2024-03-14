package com.pd.pd_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/test")
    public String homePage(Model model)
    {
        model.addAttribute("filename", "blocks/test :: test");
        return "page";
    }

    @GetMapping("/")
    public String otherPage(Model model)
    {
        model.addAttribute("filename", "blocks/content :: content");
        return "page";
    }
}
