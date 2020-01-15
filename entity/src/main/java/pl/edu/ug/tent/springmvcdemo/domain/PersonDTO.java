package pl.edu.ug.tent.springmvcdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {
    public List<Person> people = new ArrayList<>();

    public PersonDTO(){

    }

    public PersonDTO(List<Person> p){
        this.people = p;
    }

    public void addPerson(Person p){
        this.people.add(p);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
