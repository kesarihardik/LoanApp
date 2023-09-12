package com.hkesari.Loan.DAO;

import com.hkesari.Loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {

    //Custom logic

    //Remaining amount group by lender_Id, customer_Id, & interest
    @Query("SELECT l.lenderId,sum(l.amount) Amount FROM Loan l GROUP BY l.lenderId")
    List<Object[]> getLentAmountByLender();

    @Query("SELECT l.customerId,sum(l.amount) Amount FROM Loan l GROUP BY l.customerId")
    List<Object[]> getDueAmountByCustomer();
}
