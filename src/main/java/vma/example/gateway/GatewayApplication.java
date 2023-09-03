package vma.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GatewayApplication {


	@Autowired
	private PaymentService paymentService;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
