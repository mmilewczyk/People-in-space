package com.agiklo.peopleinspaceapi.Controller;

import com.agiklo.peopleinspaceapi.Person;
import com.agiklo.peopleinspaceapi.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Iterable<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public Person addNewPerson(@RequestBody Person person){
        return personService.addNewPerson(person);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        personService.deleteById(id);
    }
}
