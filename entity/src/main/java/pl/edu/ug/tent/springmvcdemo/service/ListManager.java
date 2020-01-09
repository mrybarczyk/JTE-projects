package pl.edu.ug.tent.springmvcdemo.service;

import java.util.List;

public interface ListManager {
    void update(int id, String type);
    void delete(int id, String type);
    void add(int id, String type);
    List<String> getAllLists();
}
