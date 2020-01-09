package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;

import java.util.List;

public interface PaymentManager {
    void addPayment(Payment p);

    List<Payment> getAllPayments();

    Payment findById(int paymentID);

    void remove(int paymentID);

    void update(Payment p);
}
