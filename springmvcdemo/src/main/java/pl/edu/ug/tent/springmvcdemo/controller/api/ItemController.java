package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Item;
import pl.edu.ug.tent.springmvcdemo.service.ItemManager;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemManager im;

    @GetMapping("/api/item")
    public List<Item> getItems() { return im.getAllItems(); }

    @PostMapping("/api/item")
    Item addItem(@RequestBody Item item){
        Item itemToAdd = new Item();
        im.addItem(itemToAdd);
        return itemToAdd;
    }

    @GetMapping("/api/item/{id}")
    Item getItem(@PathVariable int itemID) {
        return im.findById(itemID);
    }

    @PutMapping("/api/item/{id}")
    Item replaceItem(@RequestBody Item item, @PathVariable int itemID) {
        return im.findById(item.getItemID());
    }

    @DeleteMapping("/api/item/{id}")
    void deleteItem(@PathVariable int itemID) {
        im.remove(itemID);
    }
}
