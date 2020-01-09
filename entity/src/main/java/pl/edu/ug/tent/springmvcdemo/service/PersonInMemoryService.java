package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.controller.validator.PersonValidator;
import pl.edu.ug.tent.springmvcdemo.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInMemoryService implements PersonManager{

    private static List<Person> people = new ArrayList<>();

    @Autowired
    private ListManager lm;

    @Override
    public void addPerson(Person p) {
        people.add(p);
        lm.add(p.getPersonID(), "Person");
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (name.equals(p.getName())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Person findById(int PersonID) {
        for (Person p : people){
            if (p.getPersonID() == PersonID) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(int PersonID) {
        Person toRemove = null;
        for (Person p : people){
            if (p.getPersonID() == PersonID){
                toRemove = p;
                break;
            }
        }
        if (toRemove != null){
            people.remove(toRemove);
            lm.delete(toRemove.getPersonID(), "Person");
        }
    }

    @Override
    public void update(Person p) {
        int foo = -1;
        if (PersonValidator.validatePeople(p)){
            for (int i = 0; i < people.size(); i++) {
                if (p.getPersonID() == people.get(i).getPersonID()) {
                    foo = i;
                    break;
                }
            }
            if (foo != -1) {
                people.set(foo, p);
                lm.update(people.get(foo).getPersonID(), "Person");
            }
        }
    }

}
