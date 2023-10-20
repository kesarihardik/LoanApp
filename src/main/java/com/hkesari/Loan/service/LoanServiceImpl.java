package com.hkesari.Loan.service;
import com.hkesari.Loan.repository.LoanRepository;
import com.hkesari.Loan.model.Loan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class LoanServiceImpl implements LoanService {
  private final LoanRepository loanRepository;
  public LoanServiceImpl(LoanRepository loanRepository){
    this.loanRepository = loanRepository;
  }
  @Override
  public List<Loan> getLoans() throws Exception{
    try{
      return loanRepository.findAll();
    }
    catch(Exception e){
     log.error("Error occurred while fetching the list of all loans. ",e);
      throw e;
    }
  }

  @Override
  public Loan getLoanById(String id) {
    try{
      Optional<Loan> loan =  loanRepository.findById(id);
      if(loan.isEmpty()) throw new RuntimeException("Loan with id - "+id+" couldn't be found.");
      return loan.get();
    }
    catch(Exception e){
      log.error("Error occurred while fetching loan with id : [{id}].Error : [{}]",id,e);
      throw e;
    }
  }

  @Override
  public Loan addLoan(Loan loan) {
    Optional<Loan> l =  loanRepository.findById(loan.getLoanId());
    if(l.isPresent()){
      log.error("Loan with id : [{}] is already present ",loan.getLoanId());
      throw new RuntimeException(String.format("Loan with id : %s is already present.",loan.getLoanId()));
    }

    if(loan.getPaymentDate().after(loan.getDueDate())){
      log.error("Payment date is greater than due date for the loan : [{}]",loan.toString());
      throw new RuntimeException("Payment date can't be greater than due date.");
    }
    return loanRepository.save(loan);
  }

  @Override
  public List<Loan> getDefaulters() {
    try{
      return loanRepository.getDefaulters();
    }
    catch(Exception e){
      log.error("Error occurred while fetching the defaulter list.",e);
      throw e;
    }
  }

  @Override
  public Double getLentAmount(String lenderId) {
    try{
      return loanRepository.getLentAmountByLender(lenderId);
    }
    catch(Exception e){
      log.error("Error occurred while fetching the amount lent by lender with id : [{}].",lenderId,e);
      throw e;
    }
  }

  @Override
  public Double getBorrowedAmount(String customerId) {
    try{
      return loanRepository.getBorrowedAmountForCustomer(customerId);
    }
    catch(Exception e){
      log.error("Error occurred while fetching the amount borrowed by customer with id : [{}].",customerId,e);
      throw e;
    }
  }
}
