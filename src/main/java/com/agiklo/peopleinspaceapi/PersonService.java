package com.agiklo.peopleinspaceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

    public Person addNewPerson(Person person){
        return personRepository.save(person);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

}
