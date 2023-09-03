package vma.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentGateway paymentGateway;

    public String processPayment(Double amount) {
        return paymentGateway.process(amount);
    }
}
