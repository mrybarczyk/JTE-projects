package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;

import java.util.List;

public interface WitcherManager {

    void addWitcher(Witcher w);

    List<Witcher> getAllWitchers();

    Witcher findById(int witcherID);

    void remove(int witcherID);

    List<Witcher> findByName(String name);

    void update(Witcher w);

}
