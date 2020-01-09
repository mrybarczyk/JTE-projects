package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Person;

import java.util.List;

public interface PersonManager {

    void addPerson(Person p);

    List<Person> getPeople();

    Person findById(int personID);

    void remove(int personID);

    List<Person> findByName(String name);

    void update(Person i);

}
