package com.hkesari.Loan;
import com.hkesari.Loan.services.LoanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(LoanService loanService){
		return runner->{
			System.out.println("Loan Application Started...");
		};
	}

}
