package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PouchManager;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;

import java.util.List;

@RestController
public class WitcherController {
    @Autowired
    private WitcherManager wm;

    @Autowired
    private PouchManager pm;

    @GetMapping("/api/witcher")
    public Iterable getWitcher() { return wm.findAll(); }

    @PostMapping("/api/witcher")
    Witcher addWitcher(@RequestBody Witcher w){
        Pouch p = new Pouch();
        pm.save(p);
        w.setPouch(p);
        wm.save(w);
        return w;
    }

    @GetMapping("/api/witcher/{id}")
    Witcher getWitcher(@PathVariable("id") int witcherID) {
        return wm.findById(witcherID).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/witcher/{id}")
    Witcher replaceWitcher(@RequestBody Witcher w, @PathVariable("id") int witcherID) {
        w.setWitcherID(witcherID);
        w.setPouch(wm.findById(witcherID).orElse(null).getPouch());
        wm.save(w);
        return wm.findById(w.getWitcherID()).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/api/witcher/{id}")
    void deleteWitcher(@PathVariable("id") int witcherID) {
        wm.delete(wm.findById(witcherID).orElseThrow(NotFoundException::new));
    }
}
