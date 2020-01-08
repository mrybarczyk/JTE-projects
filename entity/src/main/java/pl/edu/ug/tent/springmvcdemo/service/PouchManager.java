package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;

public interface PouchManager extends CrudRepository<Pouch, Integer> {
}
