package com.pd.pd_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {
    @GetMapping("/roles")
    public String getAllRoles(Model model)
    {
        model.addAttribute("title", "Роли");
        return "roles";
    }
}
