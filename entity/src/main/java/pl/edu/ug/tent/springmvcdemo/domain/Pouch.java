package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pouch")
public class Pouch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pouchID;

    public Pouch(){

    }

    public int getPouchID() {
        return pouchID;
    }

    public void setPouchID(int pouchID) {
        this.pouchID = pouchID;
    }

}
