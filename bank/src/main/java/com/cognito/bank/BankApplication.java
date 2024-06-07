package com.cognito.bank;

import com.cognito.bank.model.Customer;
import com.cognito.bank.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

    public BankApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = customerRepository.save(new Customer("Emil","Bayarov"));
		Customer customer2 = customerRepository.save(new Customer("Elmar","Bayarov"));
		System.out.println(customer1);
		System.out.println(customer2);
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}
}
