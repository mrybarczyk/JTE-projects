package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.ug.tent.springmvcdemo.service.ListManager;

@Controller("listwebcontroller")
public class ListController {
    private ListManager lm;

    @Autowired
    public ListController(ListManager lm){ this.lm = lm;}

    @GetMapping("/listall")
    public String listall(Model model){
        model.addAttribute("list", lm.getAllLists());
        return "listall";
    }
}
