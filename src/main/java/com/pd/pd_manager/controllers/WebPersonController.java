package com.pd.pd_manager.controllers;

import com.pd.pd_manager.model.Person;
import com.pd.pd_manager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@ComponentScan
@Controller
@RequestMapping("web/persons")
public class WebPersonController
{

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String personsPage(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);
        model.addAttribute("URL", "/web/persons");
        return "persons/main";
    }

    @GetMapping({"/add"})
    public String getAddPerson(Model model) {
        return "persons/add";
    }

    @PostMapping({"/add"})
    public String postAddPerson(@RequestParam String first_name,
                                @RequestParam String last_name,
                                @RequestParam String patronymic_name,
                                @RequestParam String birthdate,
                                Model model) {
        System.out.printf("%s  %s  %s\n", first_name, last_name, patronymic_name);
        personService.add(first_name, last_name, patronymic_name, birthdate);
        return "redirect:/web/persons/";
    }
}
