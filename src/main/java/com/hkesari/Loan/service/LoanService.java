package com.hkesari.Loan.service;

import com.hkesari.Loan.model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getLoans() throws  Exception;
    Loan getLoanById(String Id)  throws  Exception;
    Loan addLoan(Loan loan)  throws  Exception;
    List<Loan> getDefaulters()  throws  Exception;
    Double getLentAmount(String lenderId)  throws  Exception;
    Double getBorrowedAmount(String customerId)  throws  Exception;
}
