package com.hkesari.Loan;

import com.hkesari.Loan.controllers.LoanController;
import com.hkesari.Loan.models.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LoanApplicationTests {
    @Test
    void contextLoads(){}

    @Autowired
    private LoanController loanController;

    //Test to check addition of a valid loan( Payment date <= Due Date)
    @Test
    void testAddValidLoan(){
      Loan l1 = new Loan("L99","C1","LEN1",10000,5000,
                new Date("05/03/2023"),
                new BigDecimal(0.01),new Date("05/03/2023"),new BigDecimal(0.0001));

      try {
          ResponseEntity responseEntity = loanController.addLoan(l1);
          Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);
          List<Loan> loans = loanController.getLoans().getBody();
          Assertions.assertEquals(1, loans.size());
          Assertions.assertEquals(l1.getLoanId(), loans.get(0).getLoanId());
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
    }

    //Test to check adding invalid loan (payment after due date)
    @Test
    void testAddInvalidLoan(){
        try{
            Loan l1=  new Loan("L111","C1","LEN1",10000,5000,
                    new Date("05/04/2023"),
                    new BigDecimal(0.01),new Date("05/03/2023"),new BigDecimal(0.0001));
            ResponseEntity responseEntity = loanController.addLoan(l1);
            Assertions.assertEquals(ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build(), responseEntity);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

      //test - find by Id
    @Test
    void testGetLoanById(){
        try{
        ResponseEntity responseEntity = loanController.getLoanById("L99")    ;
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);
       }
        catch(Exception ex){
        System.out.println(ex.getMessage());
       }
    }



}
