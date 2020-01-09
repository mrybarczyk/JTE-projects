package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;

import java.util.List;

public interface PouchManager {

    void addPouch(Pouch p);

    List<Pouch> getAllPouches();

    Pouch findById(int pouchID);

    void remove(int pouchID);

    void update(Pouch p);

}
