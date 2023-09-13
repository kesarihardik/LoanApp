package com.hkesari.Loan.service;

import com.hkesari.Loan.entity.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();

    Loan findById(String Id);

    Loan save(Loan loan);

    Loan updateLoan(String id, Loan loanBody);

    List<Loan> getDefaulters();

    List<Object[]> lenderData();

    List<Object[]> customerData();

}
