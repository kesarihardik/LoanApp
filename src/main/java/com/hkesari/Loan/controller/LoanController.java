package com.hkesari.Loan.controller;

import com.hkesari.Loan.model.Loan;
import com.hkesari.Loan.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/loans")
@Slf4j
@RestController
public class LoanController {
  private final LoanService loanService;
  public LoanController(LoanService loanService) {
      this.loanService = loanService;
  }
  @GetMapping("/")
  public ResponseEntity<List<Loan>> getLoans() throws Exception {
      log.info("Request received for the list of all loans.");
     return ResponseEntity.ok(loanService.getLoans());
  }
  @GetMapping("/{id}")
    public ResponseEntity<Object> getLoanById(@PathVariable String id) {
      log.info("Request received for finding the loan with id : [{}]", id);
        try{
            Loan loanBody = loanService.getLoanById(id);
            return ResponseEntity.ok(loanBody);
        }
        catch(Exception ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
  }
  @PostMapping("/")
  public ResponseEntity<Object> addLoan(@RequestBody Loan loan){
      log.info("Request received for adding a loan : [{}] ",loan.toString());
      try{
          Loan loanBody = loanService.addLoan(loan);
          return ResponseEntity.status(HttpStatus.CREATED).body(loanBody);
      }
      catch(Exception ex){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
      }
  }
  @GetMapping("/defaulters")
    public ResponseEntity<List<Loan>> getDefaulters() throws Exception {
      log.info("Request received for the list of defaulter loans.");
      return ResponseEntity.ok(loanService.getDefaulters());
  }

  @GetMapping("/lentAmount/{lenderId}")
  public ResponseEntity<Double> getLentAmount(@PathVariable String lenderId) throws Exception {
      log.info("Request received for getting the amount lent by lender with id : [{}] ",lenderId);
        return ResponseEntity.ok(loanService.getLentAmount(lenderId));
  }
   @GetMapping("/borrowedAmount/{customerId}")
   public ResponseEntity<Double> getBorrowedAmount(@PathVariable String customerId) throws Exception {
      log.info("Request received for getting the amount borrowed by customer with id : [{}] ",customerId);
        return ResponseEntity.ok(loanService.getBorrowedAmount(customerId));
  }
}
