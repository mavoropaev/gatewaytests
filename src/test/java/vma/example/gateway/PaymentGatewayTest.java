package vma.example.gateway;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentGatewayTest {

    private PaymentGateway paymentGateway = new PaymentGateway();

    @Test
    public void testProcessPayment_amountIsNull() {
        // Реализация теста
        try {
            Assert.assertNull(paymentGateway.process(null));
        }catch (RuntimeException ex){
            Assert.assertEquals("Сумма платежа не может быть null", ex.getMessage());
        }
    }

    @Test
    public void testProcessPayment_amountMore100(){
        Assert.assertEquals("Платеж успешно обработан", paymentGateway.process(100.0));
    }

    @Test
    public void testProcessPayment_amountLess100(){
        Assert.assertEquals("Платеж отклонен", paymentGateway.process(99.0));
    }
}