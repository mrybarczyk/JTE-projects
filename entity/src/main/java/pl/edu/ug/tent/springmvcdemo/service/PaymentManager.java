package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.tent.springmvcdemo.domain.Payment;

public interface PaymentManager extends CrudRepository<Payment, Integer> {
}
