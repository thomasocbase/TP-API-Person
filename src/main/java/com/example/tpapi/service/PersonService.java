package com.example.tpapi.service;

import com.example.tpapi.model.Person;
import com.example.tpapi.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public boolean updatePerson(int id, Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            personRepository.save(person);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePerson(int id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
