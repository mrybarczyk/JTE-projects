package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Person;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PersonManager;

import java.util.List;

@RestController
public class PersonController {
  @Autowired
  private PersonManager pm;

  @GetMapping("/api/person")
  public List<Person> getPerson() { return pm.getPeople(); }

  @PostMapping("/api/person")
  Person addPerson(@RequestBody Person p){
    Person pToAdd = new Person();
    pm.addPerson(pToAdd);
    return pToAdd;
  }

  @GetMapping("/api/person/{id}")
  Person getPerson(@PathVariable int personID) {
    return pm.findById(personID);
  }

  @PutMapping("/api/person/{id}")
  Person replacePerson(@RequestBody Person p, @PathVariable int personID) {
    return pm.findById(p.getPersonID());
  }

  @DeleteMapping("/api/person/{id}")
  void deletePerson(@PathVariable int personID) {
    pm.remove(personID);
  }
}
