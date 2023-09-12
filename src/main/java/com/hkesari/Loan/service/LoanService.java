package com.hkesari.Loan.service;

import com.hkesari.Loan.entity.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();

    ResponseEntity<?> findById(String Id);

    ResponseEntity<?> save(Loan loan);

    ResponseEntity<?> updateLoan(String id, Loan loanBody);

    List<Object[]> lenderData();

    List<Object[]> customerData();

}
