package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PaymentManager;

@RestController
public class PaymentController {
    @Autowired
    private PaymentManager pm;

    @GetMapping("/api/payment")
    public Iterable getPayments() {
        return pm.findAll();
    }

    @PostMapping("/api/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@RequestBody Payment p) {
        return pm.save(p);
    }

    @GetMapping("/api/payment/{id}")
    public Payment findOne(@PathVariable int id) {
        return pm.findById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/payment/{id}")
    public Payment update(@RequestBody Payment p, @PathVariable int id) {
        if (p.getPaymentID() != id) {
            throw new IdMismatchException();
        }
        pm.findById(id)
                .orElseThrow(NotFoundException::new);
        return pm.save(p);
    }

    @DeleteMapping("/api/payment/{id}")
    public void delete(@PathVariable int id) {
        pm.findById(id).orElseThrow(NotFoundException::new);
        pm.deleteById(id);
    }
}
