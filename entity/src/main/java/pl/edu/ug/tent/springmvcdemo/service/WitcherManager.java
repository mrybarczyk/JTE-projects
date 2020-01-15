package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;

import java.util.List;

public interface WitcherManager extends CrudRepository<Witcher, Integer>{


}
