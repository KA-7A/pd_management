package com.pd.pd_manager.controllers;

import com.pd.pd_manager.model.Persons;
import com.pd.pd_manager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@Controller
@RequestMapping("/web/persons")
public class WebPersonController
{

    @Autowired
    private PersonService personService;

    @GetMapping({"/", ""})
    public String personsPage(Model model) {
        List<Persons> persons = personService.getAll();
        model.addAttribute("title", "Пользователи");
        model.addAttribute("persons", persons);
        model.addAttribute("URL", "/web/persons");
        return "persons/main";
    }

    @GetMapping({"/add"})
    public String getAddPerson(Model model) {
        model.addAttribute("title", "Добавление пользователя.");
        return "persons/add";
    }

    @PostMapping({"/add"})
    public String postAddPerson(@RequestParam String first_name,
                                @RequestParam String last_name,
                                @RequestParam String patronymic_name,
                                @RequestParam String birthdate,
                                Model model) {
        personService.add(first_name, last_name, patronymic_name, birthdate);
        return "redirect:/web/persons/";
    }

    @GetMapping("edit/{id}")
    public String editPerson(@PathVariable("id") Long person_id, Model model)
    {
        Persons person = personService.getById(person_id);
        model.addAttribute("person", person);
        return "persons/edit";
    }

    @PostMapping({"/edit"})
    public String postEditPerson(@RequestParam Long person_id,
                                 @RequestParam String first_name,
                                 @RequestParam String last_name,
                                 @RequestParam String patronymic_name,
                                 @RequestParam String birthdate,
                                 Model model) {
        System.out.printf("%s  %s  %s\n", first_name, last_name, patronymic_name);
        personService.update(person_id, first_name, last_name, patronymic_name, birthdate);
        return "redirect:/web/persons/";
    }

    @GetMapping({"/delete/{id}"})
    @PostMapping({"/delete/{id}"})
    public String deletePerson(@PathVariable("id") Long person_id)
    {
        personService.delete(person_id);
        return "redirect:/web/persons/";
    }

    @GetMapping("/error")
    public String errorPage(Model model)
    {
        model.addAttribute("title", "Упс! Ошибка...");
        return "redirect:/error";
    }
}
