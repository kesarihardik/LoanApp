package com.hkesari.Loan.service;
import com.hkesari.Loan.DAO.LoanRepository;
import com.hkesari.Loan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  @Override
  public Loan findById(String id) {
    Optional<Loan> res = loanRepository.findById(id);

    Loan theLoan = null;

    if(res.isPresent()){
      theLoan =res.get();
    }
    else throw new RuntimeException("There is no loan in the loan store with the id : " + id);

    return theLoan;
  }

  @Override
  public String save(Loan loan) {
    System.out.println(loan.getPaymentDate());
      loanRepository.save(loan);
      return ("Loan with id-" + loan.getLoanId()+ " added to the loan store."+ loan.getPaymentDate());
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
