package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.controller.validator.WitcherValidator;
import pl.edu.ug.tent.springmvcdemo.domain.Witcher;

import java.util.ArrayList;
import java.util.List;

@Service
public class WitcherInMemoryService implements WitcherManager{

    private static List<Witcher> witchers = new ArrayList<>();

    @Autowired
    private ListManager lm;

    @Override
    public void addWitcher(Witcher p) {
        witchers.add(p);
        lm.add(p.getWitcherID(), "Witcher");
    }

    @Override
    public List<Witcher> getAllWitchers() {
        return witchers;
    }

    @Override
    public List<Witcher> findByName(String name) {
        List<Witcher> result = new ArrayList<>();
        for (Witcher p : witchers) {
            if (name.equals(p.getName())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Witcher findById(int WitcherID) {
        for (Witcher p : witchers){
            if (p.getWitcherID() == WitcherID) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(int WitcherID) {
        Witcher toRemove = null;
        for (Witcher p : witchers){
            if (p.getWitcherID() == WitcherID){
                toRemove = p;
                break;
            }
        }
        if (toRemove != null){
            witchers.remove(toRemove);
            lm.delete(toRemove.getWitcherID(), "Witcher");
        }
    }

    @Override
    public void update(Witcher p) {
        int foo = -1;
        if (WitcherValidator.validateWitcher(p)){
            for (int i = 0; i < witchers.size(); i++) {
                if (p.getWitcherID() == witchers.get(i).getWitcherID()) {
                    foo = i;
                    break;
                }
            }
            if (foo != -1) {
                witchers.set(foo, p);
                lm.update(witchers.get(foo).getWitcherID(), "Witcher");
            }
        }
    }

}
