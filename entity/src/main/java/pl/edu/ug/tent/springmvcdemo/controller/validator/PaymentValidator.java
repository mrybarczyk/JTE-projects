package pl.edu.ug.tent.springmvcdemo.controller.validator;

import pl.edu.ug.tent.springmvcdemo.domain.Payment;

public class PaymentValidator {
    public static boolean validatePayments(Payment p){
        if (p.getValue() < 0) return false;
        return true;
    }
}
