package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.controller.validator.PouchValidator;
import pl.edu.ug.tent.springmvcdemo.domain.Pouch;

import java.util.ArrayList;
import java.util.List;

@Service
public class PouchInMemoryService implements PouchManager{

    private static List<Pouch> pouches = new ArrayList<>();

    @Autowired
    private ListManager lm;

    @Override
    public void addPouch(Pouch p) {
        pouches.add(p);
        lm.add(p.getPouchID(), "Pouch");
    }

    @Override
    public List<Pouch> getAllPouches() {
        return pouches;
    }

    @Override
    public Pouch findById(int PouchID) {
        for (Pouch p : pouches){
            if (p.getPouchID() == PouchID) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(int PouchID) {
        Pouch toRemove = null;
        for (Pouch p : pouches){
            if (p.getPouchID() == PouchID){
                toRemove = p;
                break;
            }
        }
        if (toRemove != null){
            pouches.remove(toRemove);
            lm.delete(toRemove.getPouchID(), "Pouch");
        }
    }

    @Override
    public void update(Pouch p) {
        int foo = -1;
        if (PouchValidator.validatePouch(p)){
            for (int i = 0; i < pouches.size(); i++) {
                if (p.getPouchID() == pouches.get(i).getPouchID()) {
                    foo = i;
                    break;
                }
            }
            if (foo != -1) {
                pouches.set(foo, p);
                lm.update(pouches.get(foo).getPouchID(), "Pouch");
            }
        }
    }

}
