package com.example.tpapi.controller;

import com.example.tpapi.model.Person;
import com.example.tpapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id).orElse(null);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping("/person/{id}")
    public boolean deletePerson(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/test")
    public String test() {
        return personService.test();
    }

}
