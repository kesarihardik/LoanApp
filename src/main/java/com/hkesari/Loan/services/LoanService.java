package com.hkesari.Loan.services;

import com.hkesari.Loan.models.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<Loan> findAll();

    Loan findById(String Id);

    Loan save(Loan loan);

    List<Loan> getDefaulters();

    List<Object[]> lenderData();

    List<Object[]> customerData();

}
