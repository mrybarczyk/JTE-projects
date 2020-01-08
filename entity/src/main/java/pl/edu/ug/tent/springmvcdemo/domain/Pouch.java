package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pouch")
public class Pouch {

    @Id
    @GeneratedValue
    private int pouchID;

    @ManyToOne
    @JoinColumn(name = "PaymentID", nullable = false)
    private List<Payment> tossacoin;

    public Pouch(){

    }

    public Pouch(int pouchID, List<Payment> tossacoin) {
        this.tossacoin = tossacoin;
    }

    public int getPouchID() {
        return pouchID;
    }

    public void setPouchID(int pouchID) {
        this.pouchID = pouchID;
    }

    public List<Payment> getTossacoin() {
        return tossacoin;
    }

    public void setTossacoin(List<Payment> tossacoin) {
        this.tossacoin = tossacoin;
    }


}
