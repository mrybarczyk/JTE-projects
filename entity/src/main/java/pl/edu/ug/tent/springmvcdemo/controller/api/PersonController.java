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
  public Iterable getPeople() {
    return pm.findAll();
  }

  @PostMapping("/api/person")
  @ResponseStatus(HttpStatus.CREATED)
  public Person create(@RequestBody Person person) {
    return pm.save(person);
  }

  @GetMapping("/api/person/{id}")
  public Person findOne(@PathVariable int id) {
    return pm.findById(id).orElseThrow(NotFoundException::new);
  }

  @PutMapping("/api/person/{id}")
  public Person update(@RequestBody Person person, @PathVariable int id) {
    if (person.getPersonID() != id) {
      throw new IdMismatchException();
    }
    pm.findById(id)
            .orElseThrow(NotFoundException::new);
    return pm.save(person);
  }

  @DeleteMapping("/api/person/{id}")
  public void delete(@PathVariable int id) {
    pm.findById(id).orElseThrow(NotFoundException::new);
    pm.deleteById(id);
  }

}
