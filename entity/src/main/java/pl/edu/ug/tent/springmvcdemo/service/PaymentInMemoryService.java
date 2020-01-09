package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.controller.validator.PaymentValidator;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInMemoryService implements PaymentManager{

    private static List<Payment> payments = new ArrayList<>();

    @Autowired
    private ListManager lm;

    @Override
    public void addPayment(Payment p) {
        payments.add(p);
        lm.add(p.getPaymentID(), "Payment");
    }

    @Override
    public List<Payment> getAllPayments() {
        return payments;
    }

    @Override
    public Payment findById(int paymentID) {
        for (Payment p : payments){
            if (p.getPaymentID() == paymentID) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(int paymentID) {
        Payment toRemove = null;
        for (Payment p : payments){
            if (p.getPaymentID() == paymentID){
                toRemove = p;
                break;
            }
        }
        if (toRemove != null){
            payments.remove(toRemove);
            lm.delete(toRemove.getPaymentID(), "Payment");
        }
    }

    @Override
    public void update(Payment p) {
        int foo = -1;
        if (PaymentValidator.validatePayments(p)){
            for (int i = 0; i < payments.size(); i++) {
                if (p.getPaymentID() == payments.get(i).getPaymentID()) {
                    foo = i;
                    break;
                }
            }
            if (foo != -1) {
                payments.set(foo, p);
                lm.update(payments.get(foo).getPaymentID(), "Payment");
            }
        }
    }

}
