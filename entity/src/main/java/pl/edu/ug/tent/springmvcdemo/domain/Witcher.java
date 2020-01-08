package pl.edu.ug.tent.springmvcdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "Witchers")
public class Witcher {

    @Id
    @GeneratedValue
    private int witcherID;

    @Column(nullable = false)
    private String name;

    @Column
    private String title;

    public Witcher(){

    }

    public Witcher(int witcherID, String name, String title, Pouch pouch) {
        this.name = name;
        this.title = title;
        this.pouch = pouch;
    }

    public int getWitcherID() {
        return witcherID;
    }

    public void setWitcherID(int witcherID) {
        this.witcherID = witcherID;
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

    public Pouch getPouch() {
        return pouch;
    }

    public void setPouch(Pouch pouch) {
        this.pouch = pouch;
    }

    @OneToOne
    @JoinColumn(name = "PouchID")
    private Pouch pouch;

}
