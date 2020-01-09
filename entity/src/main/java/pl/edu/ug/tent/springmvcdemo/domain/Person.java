package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "People")
public class Person {

    @Id
    @GeneratedValue
    private int personID;

    @Column(nullable = false)
    private String name;

    @Column
    private String title;

    public Person(){

    }

    public Person(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
