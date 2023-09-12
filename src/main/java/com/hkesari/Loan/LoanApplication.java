package com.hkesari.Loan;
import com.hkesari.Loan.entity.Loan;
import com.hkesari.Loan.service.LoanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(LoanService loanService){
		return runner->{
			System.out.println("Loan Application");
		};
	}

}
