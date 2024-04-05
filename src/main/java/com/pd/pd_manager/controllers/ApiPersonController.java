package com.pd.pd_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.pd.pd_manager.service.PersonService;
import com.pd.pd_manager.model.Persons;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/api/v1/persons")
public class ApiPersonController {

    @Autowired
    private PersonService personService;

    @GetMapping({"/", ""})
    public List<Persons> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Persons getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam Persons person) {
        personService.add(person);
    }

    @PostMapping("/update")
    public void edit(@RequestParam Persons person) {personService.update(person.getId_person_inst(), person); }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    public void update(Long id, Persons person) {
        personService.update(id, person);
    }
    // Другие методы для API
}
