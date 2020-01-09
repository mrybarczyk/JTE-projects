package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;
import pl.edu.ug.tent.springmvcdemo.service.PouchManager;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;
import javax.validation.Valid;

@Controller("Witcherwebcontroller")
public class WitcherController {

    @Autowired
    private WitcherManager wm;

    @Autowired
    private PouchManager pm;

    @Autowired
    public WitcherController(WitcherManager wm) {
        this.wm = wm;
        this.pm = pm;
    }

    @GetMapping("/witcher")
    public String home(Model model){
        model.addAttribute("witchers", wm.getAllWitchers());
        return "all-witchers";
    }

    @GetMapping("/witcher/new")
    public String newWitcher(Model model){
        model.addAttribute("witcher", new Witcher());
        return "witcher-add";
    }

    @GetMapping("/witcher/delete/{WitcherID}")
    public String deleteWitcher(@PathVariable("WitcherID") int id, Model model) {
        Witcher getThePouch = wm.findById(id);
        Pouch wPouch = pm.findById(getThePouch.getWitcherID());
        pm.remove(wPouch.getPouchID());
        wm.remove(id);
        model.addAttribute("witchers", wm.getAllWitchers());
        return "all-witchers";
    }

    @PostMapping("/witcher/add")
    public String addWitcher(Witcher p, Model model) {
        Pouch newPouch = new Pouch();
        pm.addPouch(newPouch);
        
        p.setPouch(newPouch);
        wm.addWitcher(p);
        model.addAttribute("witchers", wm.getAllWitchers());
        return "all-witchers";
    }

    @PostMapping("/witcher/update/{WitcherID}")
    public String updateWitcher(@PathVariable("WitcherID") int id, Witcher p, Model model){
        p.setWitcherID(id);
        wm.update(p);
        model.addAttribute("witchers", wm.getAllWitchers());
        return "all-witcher";
    }

    @GetMapping("/witcher/edit/{WitcherID}")
    public String editWitcher(@PathVariable("WitcherID") int id, Model model){
        model.addAttribute("witcher", wm.findById(id));
        return "witcher-update";
    }

}
