package com.hkesari.Loan;

import com.hkesari.Loan.DAO.LoanRepository;
import com.hkesari.Loan.models.Loan;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class LoanRepositoryTests {

    @Autowired
    private LoanRepository loanRepository;
    @Test
    @Transactional
    public void testSaveAndFindById(){
       Loan loan = new Loan("L99","C1","LEN1",10000,5000,new Date("05/01/2023"),
               new BigDecimal(0.01),new Date("05/03/2023"),new BigDecimal(0.0001));

       Loan savedLoan = loanRepository.save(loan);

        Optional<Loan> retrievedLoan = loanRepository.findById(savedLoan.getLoanId());

        // Assert
        assertTrue(retrievedLoan.isPresent());
        assertEquals(savedLoan.getLoanId(), retrievedLoan.get().getLoanId());
    }
}
