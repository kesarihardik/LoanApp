package com.hkesari.Loan.services;
import com.hkesari.Loan.dao.LoanRepository;
import com.hkesari.Loan.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {
  private final LoanRepository loanRepository;
  @Autowired
  public LoanServiceImpl(LoanRepository loanRepository){
    this.loanRepository = loanRepository;
  }

  @Override
  public List<Loan> findAll() {
    return loanRepository.findAll();
  }

  @Override
  public Loan findById(String id) {
    Optional<Loan> loan =  loanRepository.findById(id);
    if(!loan.isPresent()) throw new RuntimeException("Loan with given id - "+id+" couldn't be found.");
    return loan.get();
  }

  @Override
  public Loan save(Loan loan) {
    Optional<Loan> l =  loanRepository.findById(loan.getLoanId());
    if(l.isPresent())
      throw new RuntimeException("Loan with given id - "+loan.getLoanId()+" already present.");

    if(loan.getPaymentDate().after(loan.getDueDate())){
      throw new RuntimeException("Payment Date can't be greater than due date. Loan Rejected.");
    }
    return loanRepository.save(loan);
  }

  @Override
  public List<Loan> getDefaulters() {
    return loanRepository.getDefaulters();
  }

  @Override
  public List<Object[]> lenderData() {
    return loanRepository.getLentAmountByLender();
  }

  @Override
  public List<Object[]> customerData() {
    return loanRepository.getDueAmountByCustomer();
  }

}
