package com.hkesari.Loan.controller;

import com.hkesari.Loan.entity.Loan;
import com.hkesari.Loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {
  private LoanService loanService;

  @Autowired
  public LoanController(LoanService loanService) {
      this.loanService = loanService;
  }

  @GetMapping("/")
  public String home(){
      return "Loan application.";
  }

  @GetMapping("/loans")
  public List<Loan> getLoans(){
     return loanService.findAll();
  }
}
