package com.hkesari.Loan.service;

import com.hkesari.Loan.model.Loan;
import com.hkesari.Loan.repository.LoanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LoanServiceImplTest {

    @MockBean
    private LoanRepository loanRepository;

    private LoanServiceImpl loanService;

    @BeforeEach
    public void setUp() {
      loanService = new LoanServiceImpl(loanRepository);
    }

    @Test
    public void shouldGetLoans() throws Exception {
        List<Loan> expectedLoans = new ArrayList<>();
        expectedLoans.add(new Loan("L1", "C1","LEN1",123113.23,2314.12,null,new BigDecimal("0.01") ,null,new BigDecimal("0.01") ));

        when(loanRepository.findAll()).thenReturn(expectedLoans);

        List<Loan> actualLoans = loanService.getLoans();

        Assertions.assertEquals(expectedLoans,actualLoans);
    }

    @Test
    public void shouldGetLoansById() throws Exception {
        Loan expectedLoan = new Loan("L1", "C1","LEN1",123113.23,2314.12,null,new BigDecimal("0.01") ,null,new BigDecimal("0.01") );

        when(loanRepository.findById(anyString())).thenReturn(Optional.of(expectedLoan));

        Loan actualLoans = loanService.getLoanById("L1");

        Assertions.assertEquals(expectedLoan,actualLoans);
    }

    @Test
    public void shouldGetDefaulters() throws Exception {
        List<Loan> expectedLoans = new ArrayList<>();
        expectedLoans.add(new Loan("L1", "C1", "LEN1", 123113.23, 2314.12, null, new BigDecimal("0.01"), null, new BigDecimal("0.01")));

        when(loanService.getDefaulters()).thenReturn(expectedLoans);
        Assertions.assertEquals(expectedLoans, loanService.getDefaulters());
    }


}
