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
  public Iterable getPerson() { return pm.findAll(); }

  @PostMapping("/api/person")
  Person addPerson(@RequestBody Person p){
    pm.save(p);
    return p;
  }

  @GetMapping("/api/person/{id}")
  Person getPerson(@PathVariable("id") int personID) {
    return pm.findById(personID).orElseThrow(NotFoundException::new);
  }

  @PutMapping("/api/person/{id}")
  Person replacePerson(@RequestBody Person p, @PathVariable("id") int personID) {
    p.setPersonID(personID);
    pm.save(p);
    return pm.findById(p.getPersonID()).orElseThrow(NotFoundException::new);
  }

  @DeleteMapping("/api/person/{id}")
  void deletePerson(@PathVariable("id") int personID) {
    pm.delete(pm.findById(personID).orElseThrow(NotFoundException::new));
  }
}
