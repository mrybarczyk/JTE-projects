package pl.edu.ug.tent.springmvcdemo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.*;
import pl.edu.ug.tent.springmvcdemo.domain.PersonDTO;
import pl.edu.ug.tent.springmvcdemo.service.PaymentManager;
import pl.edu.ug.tent.springmvcdemo.service.PersonManager;
import pl.edu.ug.tent.springmvcdemo.service.PouchManager;
import pl.edu.ug.tent.springmvcdemo.service.WitcherManager;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller("Paymentwebcontroller")
public class PaymentController {

    @Autowired
    private PaymentManager pm;

    @Autowired
    private PouchManager pcm;

    @Autowired
    private WitcherManager wm;

    @Autowired
    private PersonManager psm;

    @Autowired
    public PaymentController(PaymentManager pm) {
        this.pm = pm;
    }

    @GetMapping("/payment")
    public String home(Model model){
        model.addAttribute("witcher", new Witcher());
        model.addAttribute("payments", pm.findAll());
        return "all-payments";
    }

    @GetMapping("/payment/new")
    public String newPayment(Model model){
        PersonDTO paymentForm = new PersonDTO();
        for (int i = 0; i < 5; i++){
            paymentForm.addPerson(new Person());
        }
        Payment payment = new Payment();
        payment.setPeople(paymentForm.getPeople());
        model.addAttribute("people", paymentForm.getPeople());
        model.addAttribute("payment", payment);
        return "payment-add";
    }

    @GetMapping("/payment/delete/{PaymentID}")
    public String deletePayment(@PathVariable("PaymentID") int id, Model model) {
        Payment p = pm.findById(id).orElse(null);
        pm.delete(p);
        model.addAttribute("payments", pm.findAll());
        return "all-payments";
    }

    @PostMapping("/payment/add")
    public String addPayment(Payment p, Model model, PersonDTO paymentForm) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Person temp = psm.findById(paymentForm.people.get(i).getPersonID()).orElse(null);
            if (temp != null) people.add(temp);
        }
        p.setPeople(people);
        Witcher w = wm.findById(p.getWitcher().getWitcherID()).orElse(null);
        p.setWitcher(w);
        Pouch pouch = w.getPouch();
        List<Pouch> b = p.getTossacoin();
        b.add(pouch);
        p.setTossacoin(b);
        w.setPouch(pouch);
        wm.save(w);
        pm.save(p);

        model.addAttribute("payments", pm.findAll());
        return "all-payments";
    }

    @PostMapping("/payment/update/{PaymentID}")
    public String updatePayment(@PathVariable("PaymentID") int id, Payment p, Model model, PersonDTO pform){
        p.setPaymentID(id);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Person temp = psm.findById(pform.people.get(i).getPersonID()).orElse(null);
            if (temp != null) people.add(temp);
        }
        p.setPeople(people);
        pm.save(p);
        model.addAttribute("payments", pm.findAll());
        return "all-payments";
    }

    @GetMapping("/payment/edit/{PaymentID}")
    public String editPayment(@PathVariable("PaymentID") int id, Model model){
        Payment p = pm.findById(id).orElse(null);
        PersonDTO pform = new PersonDTO();
        for (int i = 0; i < 5; i++){
            pform.addPerson(new Person());
        }
        p.setPeople(pform.getPeople());
        model.addAttribute("payment", p);
        model.addAttribute("people", pform.getPeople());
        return "payment-update";
    }

}
