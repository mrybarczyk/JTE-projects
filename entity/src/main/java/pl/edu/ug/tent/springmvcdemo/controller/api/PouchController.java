package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PouchManager;

@RestController
public class PouchController {
    @Autowired
    private PouchManager pm;

    @GetMapping("/api/pouch")
    public Iterable getPouches() {
        return pm.findAll();
    }

    @PostMapping("/api/pouch")
    @ResponseStatus(HttpStatus.CREATED)
    public Pouch create(@RequestBody Pouch p) {
        return pm.save(p);
    }

    @GetMapping("/api/pouch/{id}")
    public Pouch findOne(@PathVariable int id) {
        return pm.findById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/pouch/{id}")
    public Pouch update(@RequestBody Pouch p, @PathVariable int id) {
        if (p.getPouchID() != id) {
            throw new IdMismatchException();
        }
        pm.findById(id)
                .orElseThrow(NotFoundException::new);
        return pm.save(p);
    }

    @DeleteMapping("/api/pouch/{id}")
    public void delete(@PathVariable int id) {
        pm.findById(id).orElseThrow(NotFoundException::new);
        pm.deleteById(id);
    }
}
