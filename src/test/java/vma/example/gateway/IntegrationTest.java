package vma.example.gateway;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testPaymentService_amountIsNull() {
        try {
            Assert.assertNull(paymentService.processPayment(null));
        }catch (RuntimeException ex){
            Assert.assertEquals("Сумма платежа не может быть null", ex.getMessage());
        }
    }
    @Test
    public void testProcessPayment_amountMore100(){
        Assert.assertEquals("Платеж успешно обработан", paymentService.processPayment(100.0));
    }

    @Test
    public void testProcessPayment_amountLess100(){
        Assert.assertEquals("Платеж отклонен", paymentService.processPayment(99.0));
    }
}