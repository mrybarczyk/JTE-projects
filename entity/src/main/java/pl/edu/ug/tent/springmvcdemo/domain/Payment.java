package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "People", nullable = false)
    private List<Person> people;

    @ManyToOne
    @JoinColumn(name = "Witcher", nullable = false)
    private Witcher witcher;

    private int value;

    @OneToMany
    @JoinColumn(name = "Payments", nullable = true)
    private List<Pouch> tossacoin = new ArrayList<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Payment(){

    }

    public Payment(List<Person> people, Witcher witcher, int value) {
        this.people = people;
        this.witcher = witcher;
        this.value = value;
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

    public List<Pouch> getTossacoin() {
        return tossacoin;
    }

    public void setTossacoin(List<Pouch> tossacoin) {
        this.tossacoin = tossacoin;
    }
}
