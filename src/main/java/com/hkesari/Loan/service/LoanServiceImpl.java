package com.hkesari.Loan.service;

import com.hkesari.Loan.DAO.LoanRepository;
import com.hkesari.Loan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
  private LoanRepository loanRepository;
  @Autowired
  public LoanServiceImpl(LoanRepository loanRepository){
    this.loanRepository = loanRepository;
  }

  @Override
  public List<Loan> findAll() {
    return loanRepository.findAll();
  }
}
