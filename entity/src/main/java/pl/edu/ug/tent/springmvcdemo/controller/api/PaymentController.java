package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;
import pl.edu.ug.tent.springmvcdemo.domain.PaymentAPIDTO;
import pl.edu.ug.tent.springmvcdemo.domain.Person;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PaymentManager;
import pl.edu.ug.tent.springmvcdemo.service.PersonManager;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentManager pm;

    @Autowired
    private WitcherManager wm;

    @Autowired private PersonManager psm;

    @GetMapping("/api/payment")
    public Iterable getPayment() { return pm.findAll(); }

    @PostMapping("/api/payment")
    Payment addPayment(@RequestBody PaymentAPIDTO p){
        Payment pToAdd = new Payment();
        List<Person> personList = new ArrayList<>();
        pToAdd.setValue(p.getValue());
        pToAdd.setWitcher(wm.findById(p.getWitcherID()).orElseThrow(NotFoundException::new));
        for (int i = 0; i < p.getPeople().size(); i++){
            Person temp = psm.findById(p.getPeople().get(i)).orElse(null);
            if (temp != null) personList.add(temp);
        }
        pToAdd.setPeople(personList);
        pm.save(pToAdd);
        return pToAdd;
    }

    @GetMapping("/api/payment/{id}")
    Payment getPayment(@PathVariable("id") int paymentID) {
        return pm.findById(paymentID).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/payment/{id}")
    Payment replacePayment(@RequestBody PaymentAPIDTO pad, @PathVariable("id") int paymentID) {
        Payment toModify = pm.findById(paymentID).orElseThrow(NotFoundException::new);
        toModify.setWitcher(wm.findById(pad.getWitcherID()).orElseThrow(NotFoundException::new));
        toModify.setValue(pad.getValue());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < pad.getPeople().size(); i++){
            Person temp = psm.findById(pad.getPeople().get(i)).orElse(null);
            if (temp != null) personList.add(temp);
        }
        toModify.setPeople(personList);
        pm.save(toModify);
        return toModify;
    }

    @DeleteMapping("/api/payment/{id}")
    void deletePayment(@PathVariable("id") int paymentID) {
        pm.delete(pm.findById(paymentID).orElseThrow(NotFoundException::new));
    }
}
