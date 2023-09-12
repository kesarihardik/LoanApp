package com.hkesari.Loan.controller;

import com.hkesari.Loan.entity.Loan;
import com.hkesari.Loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.constant.Constable;
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

  @GetMapping("/loans/{id}")
    public Loan getEmployee(@PathVariable String id) {
        Loan loan= loanService.findById(id);

        if(loan==null)
            throw new RuntimeException("Loan id not found " + id);
        return loan;
  }

  @GetMapping("/lenderData")
    public List<Object[]> lenderData() {
        return loanService.lenderData();
  }

  @GetMapping("/customerData")
    public List<Object[]> customerData() {
        return loanService.customerData();
  }

  @PostMapping("/loans")
    String addEmployee(@RequestBody Loan employee){
        return loanService.save(employee);
  }


//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        Employee dbEmployee = employeeService.save(employee);
//        return dbEmployee;
//    }
}
