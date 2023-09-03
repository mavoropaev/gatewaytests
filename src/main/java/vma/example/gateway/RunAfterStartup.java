package vma.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Profile("!test")
@Component
public class RunAfterStartup {
    @Autowired
    private PaymentService paymentService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup(){
        System.out.println("Введите сумму платежа:");
        BufferedReader br = null;
        double summa = 0;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            summa = Double.parseDouble(br.readLine());
            System.out.println(summa);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(paymentService.processPayment(summa));



    }
}

