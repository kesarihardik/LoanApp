package com.hkesari.Loan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.hkesari.Loan.DAO.LoanRepository;
import com.hkesari.Loan.models.Loan;
import com.hkesari.Loan.services.LoanService;
import com.hkesari.Loan.services.LoanServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTests {
    @InjectMocks
    private LoanServiceImpl loanService;

    @Mock
    private LoanRepository loanRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveLoan(){
        Loan loanToSave = new Loan("L99","C1","LEN1",10000,5000,new Date("05/01/2023"),
                new BigDecimal(0.01),new Date("05/03/2023"),new BigDecimal(0.0001));
        Loan savedLoan = new Loan("L99","C1","LEN1",10000,5000,new Date("05/01/2023"),
                new BigDecimal(0.01),new Date("05/03/2023"),new BigDecimal(0.0001));

        when(loanRepository.save(loanToSave)).thenReturn(savedLoan);

        // Act
        Loan result = loanService.save(loanToSave);

        // Assert
        assertEquals(savedLoan, result);
    }
}
