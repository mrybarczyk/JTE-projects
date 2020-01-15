package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Person;

import java.util.List;

public interface PersonManager extends CrudRepository<Person, Integer>{

}
