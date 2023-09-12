package com.hkesari.Loan.service;

import com.hkesari.Loan.entity.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();

    Loan findById(String Id);

    String save(Loan loan);

    List<Object[]> lenderData();

    List<Object[]> customerData();
}
