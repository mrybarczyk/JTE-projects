package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;
import pl.edu.ug.tent.springmvcdemo.exception.IdMismatchException;
import pl.edu.ug.tent.springmvcdemo.exception.NotFoundException;
import pl.edu.ug.tent.springmvcdemo.service.PaymentManager;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentManager pm;

    @GetMapping("/api/payment")
    public Iterable getPayment() { return pm.findAll(); }

    @PostMapping("/api/payment")
    Payment addPayment(@RequestBody Payment p){
        Payment pToAdd = new Payment();
        pm.save(pToAdd);
        return pToAdd;
    }

    @GetMapping("/api/payment/{id}")
    Payment getPayment(@PathVariable int paymentID) {
        return pm.findById(paymentID).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/api/payment/{id}")
    Payment replacePayment(@RequestBody Payment p, @PathVariable int paymentID) {
        return pm.findById(p.getPaymentID()).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/api/payment/{id}")
    void deletePayment(@PathVariable int paymentID) {
        pm.delete(pm.findById(paymentID).orElseThrow(NotFoundException::new));
    }
}