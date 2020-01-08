package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;

@RestController
public class WitcherController {
    @Autowired
    private WitcherManager wm;

    @GetMapping("/api/witcher")
    public Iterable getWitchers() {
        return wm.findAll();
    }

    @PostMapping("/api/witcher")
    @ResponseStatus(HttpStatus.CREATED)
    public Witcher create(@RequestBody Witcher w) {
        return wm.save(w);
    }

    @GetMapping("/api/witcher/{id}")
    public Witcher findOne(@PathVariable int id) {
        return wm.findById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/witcher/{id}")
    public Witcher update(@RequestBody Witcher w, @PathVariable int id) {
        if (w.getWitcherID() != id) {
            throw new IdMismatchException();
        }
        wm.findById(id)
                .orElseThrow(NotFoundException::new);
        return wm.save(w);
    }

    @DeleteMapping("/api/witcher/{id}")
    public void delete(@PathVariable int id) {
        wm.findById(id).orElseThrow(NotFoundException::new);
        wm.deleteById(id);
    }
}
