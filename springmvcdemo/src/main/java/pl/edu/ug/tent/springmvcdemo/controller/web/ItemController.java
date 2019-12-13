package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Item;
import pl.edu.ug.tent.springmvcdemo.service.ItemManager;

import javax.validation.Valid;

@Controller("itemwebcontroller")
public class ItemController {

    @Autowired
    private ItemManager im;

    @Autowired
    public ItemController(ItemManager im) {
        this.im = im;
    }

    @GetMapping("/item")
    public String home(Model model){
        model.addAttribute("items", im.getAllItems());
        return "item-all";
    }

    @GetMapping("/item/new")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "item-add";
    }

    @GetMapping("/item/delete/{itemID}")
    public String deleteItem(@PathVariable("itemID") int id, Model model) {
        im.remove(id);
        model.addAttribute("items", im.getAllItems());
        return "item-all";
    }

    @PostMapping("/item/add")
    public String addItem(Item item, Model model) {
        im.addItem(item);
        model.addAttribute("items", im.getAllItems());
        return "item-all";
    }

    @PostMapping("/item/update/{itemID}")
    public String updateItem(@PathVariable("itemID") int id, Item item, Model model){
        item.setItemID(id);
        im.update(item);
        model.addAttribute("items", im.getAllItems());
        return "item-all";
    }

    @GetMapping("/item/edit/{itemID}")
    public String editItem(@PathVariable("itemID") int id, Model model){
        model.addAttribute("item", im.findById(id));
        return "item-update";
    }

}
