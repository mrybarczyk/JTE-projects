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
        model.addAttribute("witchers", wm.findAll());
        return "all-witchers";
    }

    @GetMapping("/witcher/new")
    public String newWitcher(Model model){
        model.addAttribute("witcher", new Witcher());
        return "witcher-add";
    }

    @GetMapping("/witcher/delete/{witcherID}")
    public String deleteWitcher(@PathVariable("witcherID") int id, Model model) {
        Witcher getThePouch = wm.findById(id).orElse(null);
        Pouch wPouch = pm.findById(getThePouch.getWitcherID()).orElse(null);
        pm.delete(wPouch);
        wm.delete(getThePouch);
        model.addAttribute("witchers", wm.findAll());
        return "all-witchers";
    }

    @PostMapping("/witcher/add")
    public String addWitcher(Witcher p, Model model) {
        Pouch newPouch = new Pouch();
        newPouch.setPouchID(p.getWitcherID());
        pm.save(newPouch);
        
        p.setPouch(newPouch);
        wm.save(p);
        model.addAttribute("witchers", wm.findAll());
        return "all-witchers";
    }

    @PostMapping("/witcher/update/{witcherID}")
    public String updateWitcher(@PathVariable("witcherID") int id, Witcher p, Model model){
        p.setWitcherID(id);
        Witcher w = wm.findById(id).orElse(null);
        p.setPouch(w.getPouch());
        wm.save(p);
        model.addAttribute("witchers", wm.findAll());
        return "all-witchers";
    }

    @GetMapping("/witcher/edit/{witcherID}")
    public String editWitcher(@PathVariable("witcherID") int id, Model model){
        Witcher w = wm.findById(id).orElse(null);
        model.addAttribute("witcher", w);
        return "witcher-update";
    }

}
