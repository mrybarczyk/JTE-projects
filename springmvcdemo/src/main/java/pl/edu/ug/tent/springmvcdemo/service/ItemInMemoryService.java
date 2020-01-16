package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Item;
import pl.edu.ug.tent.springmvcdemo.validator.ItemValidator;

import javax.swing.text.html.HTMLWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItemInMemoryService implements ItemManager {

    private static List<Item> items = new ArrayList<>();

    @Autowired
    private ListManager lm;

    public void addItem(Item item) {
        Random r = new Random();
        int max = 1000000;
        int min = 1;
        int a  = r.nextInt((max - min) +1) + min;
        item.setItemID(a);
        items.add(item);
        lm.add(item.getItemID());
    }

    @Override
    public Item findById(int id) {
        for (Item item : items) {
            if (item.getItemID() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public void remove(int id) {
        Item toRemove = null;
        for (Item item : items) {
            if (item.getItemID() == id) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
            lm.delete(toRemove.getItemID());
        }
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (name.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void update(Item item){
        int foo = -1;
        if (ItemValidator.validateItems(item)) {
            for (int i = 0; i < items.size(); i++) {
                if (item.getItemID() == items.get(i).getItemID()) {
                    foo = i;
                    break;
                }
            }
            if (foo != -1) {
                items.set(foo, item);
                lm.update(items.get(foo).getItemID());
            }
        }
    }
}
