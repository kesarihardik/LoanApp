package com.hkesari.Loan.controllers;

import com.hkesari.Loan.models.Loan;
import com.hkesari.Loan.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/loans")
@RestController
public class LoanController {
  private final LoanService loanService;

  @Autowired
  public LoanController(LoanService loanService) {
      this.loanService = loanService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Loan>> getLoans(){
     return ResponseEntity.ok(loanService.findAll());
  }

  @GetMapping("/{id}")
    public ResponseEntity<Object> getLoanById(@PathVariable String id) {
        try{
            Loan loanBody = loanService.findById(id);
            return ResponseEntity.ok(loanBody);
        }
        catch(RuntimeException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
  }

  @PostMapping("/")
  ResponseEntity<Object> addEmployee(@RequestBody Loan loan){
      try{
          Loan loanBody = loanService.save(loan);
          return ResponseEntity.status(HttpStatus.CREATED).body(loanBody);
      }
      catch(RuntimeException ex){
          return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
      }
  }

  @GetMapping("/defaulters")
    public ResponseEntity<Object> getDefaulters() {
        return ResponseEntity.ok(loanService.getDefaulters());
  }
  @GetMapping("/lenderData")
  public ResponseEntity<List<Object[]>> lenderData() {
        return ResponseEntity.ok(loanService.lenderData());
  }

   @GetMapping("/customerData")
   public ResponseEntity<List<Object[]>> customerData() {
        return ResponseEntity.ok(loanService.customerData());
  }
}
