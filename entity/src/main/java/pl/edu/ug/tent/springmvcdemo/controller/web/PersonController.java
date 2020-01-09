package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Person;
import pl.edu.ug.tent.springmvcdemo.service.PersonManager;
import javax.validation.Valid;

@Controller("Personwebcontroller")
public class PersonController {

  @Autowired
  private PersonManager pm;

  @Autowired
  public PersonController(PersonManager pm) {
    this.pm = pm;
  }

  @GetMapping("/person")
  public String home(Model model){
    model.addAttribute("people", pm.getPeople());
    return "all-people";
  }

  @GetMapping("/person/new")
  public String newPerson(Model model){
    model.addAttribute("person", new Person());
    return "person-add";
  }

  @GetMapping("/person/delete/{PersonID}")
  public String deletePerson(@PathVariable("PersonID") int id, Model model) {
    pm.remove(id);
    model.addAttribute("people", pm.getPeople());
    return "all-people";
  }

  @PostMapping("/person/add")
  public String addPerson(Person Person, Model model) {
    pm.addPerson(Person);
    model.addAttribute("people", pm.getPeople());
    return "all-people";
  }

  @PostMapping("/person/update/{PersonID}")
  public String updatePerson(@PathVariable("PersonID") int id, Person Person, Model model){
    Person.setPersonID(id);
    pm.update(Person);
    model.addAttribute("people", pm.getPeople());
    return "all-people";
  }

  @GetMapping("/person/edit/{PersonID}")
  public String editPerson(@PathVariable("PersonID") int id, Model model){
    model.addAttribute("person", pm.findById(id));
    return "person-update";
  }

}
