package com.pd.pd_manager.service;

import com.pd.pd_manager.interfaces.ReferenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.pd.pd_manager.repository.PersonRepository;
import com.pd.pd_manager.model.Persons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PersonService implements ReferenceInterface<Persons> {

    static private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Persons> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id_person");
         return personRepository.findAll().stream()
                 .sorted(Comparator.comparingLong(Persons::getId_person_inst))
                 .toList();
    }

    @Override
    public Persons getById(Long id) {
        return personRepository.findById(id).orElse(null
        );
    }

    @Override
    public void add(Persons person) {
        personRepository.save(person);
    }

    public void add(String first_name, String last_name, String patronymic_name, String birthdate) {

        Persons person = new Persons();
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
    public void update(Long id, Persons person) {
        personRepository.deleteById(id);
        personRepository.save(person);
    }

    public void update(Long personId, String firstName, String lastName, String patronymicName, String birthdate) {
        Persons person = personRepository.getReferenceById(personId);
        try {
            person.setDt_birthdate(formatter.parse(birthdate));
        } catch (ParseException e) {
            person.setDt_birthdate(person.getDt_birthdate());
        }
        person.setV_name(firstName);
        person.setV_last_name(lastName);
        person.setV_patronymic_name(patronymicName);
        
        personRepository.save(person);
    }

}
