package com.hkesari.Loan;

import com.hkesari.Loan.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoanApplicationTests {

	private LoanService loanService;
	@Autowired
	public LoanApplicationTests(LoanService loanService){
		this.loanService = loanService;
	}

	@Test
	void contextLoads() {

	}

}
