package com.hkesari.Loan.DAO;

import com.hkesari.Loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, String> {
}
