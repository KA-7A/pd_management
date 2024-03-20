package com.pd.pd_manager.service;

import com.pd.pd_manager.interfaces.ReferenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.pd.pd_manager.repository.PersonRepository;
import com.pd.pd_manager.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PersonService implements ReferenceInterface<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id_person");
         return personRepository.findAll().stream()
                 .sorted(Comparator.comparingLong(Person::getId_person))
                 .toList();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null
        );
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    public void add(String first_name, String last_name, String patronymic_name, String birthdate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Person person = new Person();
        try {
            person.setDt_birthdate(formatter.parse(birthdate));
        } catch (ParseException e)
        {
            person.setDt_birthdate(new Date());
        }
        person.setV_name(first_name);
        person.setV_last_name(last_name);
        person.setV_patronymic_name(patronymic_name);
        personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Person person) {
        personRepository.deleteById(id);
        personRepository.save(person);
    }
    // Другие методы для API
}
