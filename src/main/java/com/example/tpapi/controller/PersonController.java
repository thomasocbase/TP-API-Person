package com.example.tpapi.controller;

import com.example.tpapi.model.Person;
import com.example.tpapi.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Person Management", description = "Operations for managing persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    @Operation(summary = "Get all persons", description = "Returns all persons in the system")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    @Operation(summary = "Get a specific person", description = "Returns a person's details. Request by user ID")
    public Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id).orElse(null);
    }

    @PostMapping("/person")
    @Operation(summary = "Add a person", description = "Add a new person to the system")
    public Person addPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/person/{id}")
    @Operation(summary = "Update a person", description = "Update an existing person in the system. Request by user ID")
    public boolean updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/person/{id}")
    @Operation(summary = "Delete a person", description = "Delete a person from the system. Request by user ID")
    public boolean deletePerson(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }

}
