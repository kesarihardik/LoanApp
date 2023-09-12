package com.hkesari.Loan;

import com.hkesari.Loan.dao.LoanDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(LoanDao loanDao){
		return runner->{
			System.out.println("Hello World");
		};
	}
}
