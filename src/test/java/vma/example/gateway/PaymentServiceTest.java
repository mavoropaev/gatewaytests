package vma.example.gateway;


//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

    @Test
    public void testProcessPayment_success() {
        Mockito.when(paymentGateway.process(100.0))
               .thenReturn("Платеж успешно обработан");

        paymentService.processPayment(100.0);
        Mockito.verify(paymentGateway, Mockito.times(1)).process(100.0);
    }
}