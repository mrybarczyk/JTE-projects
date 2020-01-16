package pl.edu.ug.tent.springmvcdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class PaymentAPIDTO {
    List<Integer> people = new ArrayList<>();
    int witcherID;
    int value;

    public PaymentAPIDTO(){

    }

    public PaymentAPIDTO(List<Integer> people, int witcherID, int value) {
        this.people = people;
        this.witcherID = witcherID;
        this.value = value;
    }

    public List<Integer> getPeople() {
        return people;
    }

    public void setPeople(List<Integer> people) {
        this.people = people;
    }

    public int getWitcherID() {
        return witcherID;
    }

    public void setWitcherID(int witcherID) {
        this.witcherID = witcherID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
