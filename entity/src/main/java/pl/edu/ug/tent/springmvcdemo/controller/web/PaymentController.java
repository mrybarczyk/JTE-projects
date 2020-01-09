package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;
import pl.edu.ug.tent.springmvcdemo.service.PaymentManager;
import javax.validation.Valid;

@Controller("Paymentwebcontroller")
public class PaymentController {

    @Autowired
    private PaymentManager pm;

    @Autowired
    public PaymentController(PaymentManager pm) {
        this.pm = pm;
    }

    @GetMapping("/payment")
    public String home(Model model){
        model.addAttribute("payments", pm.getAllPayments());
        return "all-payments";
    }

    @GetMapping("/payment/new")
    public String newPayment(Model model){
        model.addAttribute("payment", new Payment());
        return "payment-add";
    }

    @GetMapping("/payment/delete/{PaymentID}")
    public String deletePayment(@PathVariable("PaymentID") int id, Model model) {
        pm.remove(id);
        model.addAttribute("payments", pm.getAllPayments());
        return "all-payments";
    }

    @PostMapping("/payment/add")
    public String addPayment(Payment p, Model model) {
        pm.addPayment(p);
        model.addAttribute("payments", pm.getAllPayments());
        return "all-payments";
    }

    @PostMapping("/payment/update/{PaymentID}")
    public String updatePayment(@PathVariable("PaymentID") int id, Payment p, Model model){
        p.setPaymentID(id);
        pm.update(p);
        model.addAttribute("payments", pm.getAllPayments());
        return "all-payments";
    }

    @GetMapping("/payment/edit/{PaymentID}")
    public String editPayment(@PathVariable("PaymentID") int id, Model model){
        model.addAttribute("payment", pm.findById(id));
        return "payment-update";
    }

}
