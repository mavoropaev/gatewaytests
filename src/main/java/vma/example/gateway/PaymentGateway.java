package vma.example.gateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGateway {
    public String process(Double amount) {
        if(amount == null) {
            throw new IllegalArgumentException("Сумма платежа не может быть null");
        }
        if(amount < 100) {
            return "Платеж отклонен";
        }
        return "Платеж успешно обработан";
    }
}
