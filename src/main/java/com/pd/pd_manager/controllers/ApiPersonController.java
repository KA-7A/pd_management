package com.pd.pd_manager.controllers;

import com.pd.pd_manager.interfaces.ReferenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.pd.pd_manager.service.PersonService;
import com.pd.pd_manager.model.Person;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("api/")
public class ApiPersonController {

    @Autowired
    private PersonService personService;

    @GetMapping({"persons/"})
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("persons/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping("persons/add/")
    public void add(@RequestParam Person person) {
        personService.add(person);
    }

    @DeleteMapping("persons/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    public void update(Long id, Person person) {
        personService.update(id, person);
    }
    // Другие методы для API
}
