package com.agiklo.peopleinspaceapi.Controller;

import com.agiklo.peopleinspaceapi.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getListOfPeople(Model model) {
        model.addAttribute("listOfPeople", personService.findAll());
        return "index";
    }
}
