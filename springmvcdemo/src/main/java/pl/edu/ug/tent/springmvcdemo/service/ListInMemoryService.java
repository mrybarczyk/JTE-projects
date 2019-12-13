package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ListInMemoryService implements ListManager {
    private static List<String> list = new ArrayList<>();

    @Override
    public void update(int id) {
        list.add(new Date(System.currentTimeMillis()) + " zmieniono obiekt " + id);
    }

    @Override
    public void delete(int id) {
        list.add(new Date(System.currentTimeMillis()) + " usunięto obiekt " + id);
    }

    @Override
    public void add(int id) {
        list.add(new Date(System.currentTimeMillis()) + " dodano obiekt " + id);
    }

    @Override
    public List<String> getAllLists() {
        return list;
    }
}
