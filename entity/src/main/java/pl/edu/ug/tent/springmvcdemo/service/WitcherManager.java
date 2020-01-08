package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;

public interface WitcherManager extends CrudRepository<Witcher, Integer> {
}
