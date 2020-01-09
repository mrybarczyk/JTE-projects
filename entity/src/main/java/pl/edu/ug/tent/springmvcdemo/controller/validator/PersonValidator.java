package pl.edu.ug.tent.springmvcdemo.controller.validator;

import pl.edu.ug.tent.springmvcdemo.domain.Person;

public class PersonValidator {
    public static boolean validatePeople(Person p){
        if (p.getName().isEmpty()) return false;
        return true;
    }
}
