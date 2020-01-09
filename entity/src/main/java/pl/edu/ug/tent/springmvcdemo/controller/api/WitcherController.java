package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;

import java.util.List;

@RestController
public class WitcherController {
    @Autowired
    private WitcherManager wm;

    @GetMapping("/api/witcher")
    public List<Witcher> getWitcher() { return wm.getAllWitchers(); }

    @PostMapping("/api/witcher")
    Witcher addWitcher(@RequestBody Witcher w){
        Witcher witcherToAdd = new Witcher();
        wm.addWitcher(witcherToAdd);
        return witcherToAdd;
    }

    @GetMapping("/api/witcher/{id}")
    Witcher getWitcher(@PathVariable int witcherID) {
        return wm.findById(witcherID);
    }

    @PutMapping("/api/witcher/{id}")
    Witcher replaceWitcher(@RequestBody Witcher w, @PathVariable int witcherID) {
        return wm.findById(w.getWitcherID());
    }

    @DeleteMapping("/api/witcher/{id}")
    void deleteWitcher(@PathVariable int witcherID) {
        wm.remove(witcherID);
    }
}
