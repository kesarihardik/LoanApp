package com.hkesari.Loan.dao;

import com.hkesari.Loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanDao extends JpaRepository<Loan, String> {
}
