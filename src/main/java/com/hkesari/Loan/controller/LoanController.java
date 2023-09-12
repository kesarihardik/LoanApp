package com.hkesari.Loan.controller;

import com.hkesari.Loan.entity.Loan;
import com.hkesari.Loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/loans")
@RestController
public class LoanController {
  private final LoanService loanService;

  @Autowired
  public LoanController(LoanService loanService) {
      this.loanService = loanService;
  }

  @GetMapping("/")
  public List<Loan> getLoans(){
     return loanService.findAll();
  }

  @GetMapping("/{id}")
    public ResponseEntity<?> getLoanById(@PathVariable String id) {
        return loanService.findById(id);
  }

  @PostMapping("/")
  ResponseEntity<?> addEmployee(@RequestBody Loan employee){
      return loanService.save(employee);
  }

    //  @PutMapping("/loans/{id}")
//    public ResponseEntity<String> updateLoan(@PathVariable String id, @RequestBody Loan loanBody){
//
//  }
  @GetMapping("/lenderData")
  public List<Object[]> lenderData() {
        return loanService.lenderData();
  }

   @GetMapping("/customerData")
   public List<Object[]> customerData() {
        return loanService.customerData();
  }

}
