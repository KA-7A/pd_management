package com.pd.pd_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.pd.pd_manager.service.PersonService;
import com.pd.pd_manager.model.Persons;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("api/")
public class ApiPersonController {

    @Autowired
    private PersonService personService;

    @GetMapping({"persons/"})
    public List<Persons> getAll() {
        return personService.getAll();
    }

    @GetMapping("persons/{id}")
    public Persons getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping("persons/add/")
    public void add(@RequestParam Persons person) {
        personService.add(person);
    }

    @DeleteMapping("persons/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    public void update(Long id, Persons person) {
        personService.update(id, person);
    }
    // Другие методы для API
}
