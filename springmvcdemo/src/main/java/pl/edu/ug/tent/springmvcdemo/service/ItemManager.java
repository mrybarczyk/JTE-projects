package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Item;
import java.util.List;

public interface ItemManager{

    void addItem(Item item);

    List<Item> getAllItems();

    Item findById(int itemID);

    void remove(int itemID);

    List<Item> findByName(String name);

    void update(Item i);
}
