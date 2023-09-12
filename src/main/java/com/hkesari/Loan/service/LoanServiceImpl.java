package com.hkesari.Loan.service;
import com.hkesari.Loan.DAO.LoanRepository;
import com.hkesari.Loan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> findById(String id) {
    Optional<Loan> loan = loanRepository.findById(id);
    if(loan.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan id - "+id+" could not be found.");
    return ResponseEntity.ok(loan.get());
  }

  @Override
  public ResponseEntity<?> save(Loan loan) {
    if(loan.getPaymentDate().after(loan.getDueDate())){
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Payment date can't be greater than due date. Loan rejected.");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(loan);
  }

  @Override
  public ResponseEntity<?> updateLoan(String id, Loan loanBody) {
    return null;
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
