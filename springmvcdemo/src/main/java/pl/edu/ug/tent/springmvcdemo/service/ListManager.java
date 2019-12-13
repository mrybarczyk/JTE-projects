package pl.edu.ug.tent.springmvcdemo.service;

import java.util.List;

public interface ListManager {
    void update(int id);
    void delete(int id);
    void add(int id);
    List<String> getAllLists();
}
