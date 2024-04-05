package com.pd.pd_manager.controllers;

import com.pd.pd_manager.model.Persons;
import com.pd.pd_manager.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MainController {
    @GetMapping({"error", "/error", "error/", "/error/"})
    public String errorPage(Model model)
    {
        // На самом деле, этот кусок не работает. Хорошо бы это как-то поправить, а то противно получается :(
        model.addAttribute("title", "Упс! Ошибка...");
        System.out.println("Мы где-то в error логе");
        return "error";
    }
    @GetMapping({"/", "/web", "/web/"})
    public String homePage(Model model)
    {
        model.addAttribute("title", "Домашняя страница");
        return "homepage";
    }

    @GetMapping({"/test", "/test/"})
    public String testPage(Model model) {
        model.addAttribute("title", "Тестовая страница!");
        model.addAttribute("person", new Persons(1, "Иван", "Иванов", "Иваныч", new Date(), null, null, null, null));
        return "example_page.html";
    }
}
