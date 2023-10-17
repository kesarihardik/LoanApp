package com.hkesari.Loan.repository;

import com.hkesari.Loan.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    @Query( value="SELECT sum(l.amount) Amount "+
                                    "FROM Loan l "+
                                    "WHERE l.lenderId= :lenderId "
    )
    Double getLentAmountByLender(@Param("lenderId") String lenderId);

    @Query( value="SELECT sum(l.amount) Amount " +
                                    "FROM Loan l "+
                                    "WHERE l.customerId = :customerId "
    )
    Double getBorrowedAmountForCustomer(@Param("customerId") String customerId);

    @Query(value = "SELECT l  FROM Loan l WHERE l.remainingAmount>0 and l.dueDate < CURRENT_TIMESTAMP()")
    List<Loan> getDefaulters() ;
}
