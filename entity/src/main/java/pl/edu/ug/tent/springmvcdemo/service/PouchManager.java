package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;

import java.util.List;

public interface PouchManager extends CrudRepository<Pouch, Integer>{

}
