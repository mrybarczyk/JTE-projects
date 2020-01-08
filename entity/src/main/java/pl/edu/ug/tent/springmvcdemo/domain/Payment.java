package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue
    private int paymentID;

    @ManyToMany
    @JoinColumn(name = "PersonID", nullable = false)
    private List<Person> people;

    @OneToMany
    @JoinColumn(name = "WitcherID", nullable = false)
    private Witcher witcher;


    public Payment(){

    }

    public Payment(int paymentID, List<Person> people, Witcher witcher) {
        this.people = people;
        this.witcher = witcher;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Witcher getWitcher() {
        return witcher;
    }

    public void setWitcher(Witcher witcher) {
        this.witcher = witcher;
    }
}
