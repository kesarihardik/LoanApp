package com.hkesari.Loan.model;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="LOANS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Loan{
    @Id
    @Column(name="LOAN_ID")
    private String loanId;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="LENDER_ID")
    private String lenderId;

    @Column(name="AMOUNT")
    private double amount;

    @Column(name="REMAINING_AMOUNT")
    private double remainingAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="PAYMENT_DATE")
    private Date paymentDate;

    @Column(name="INTEREST_PER_DAY", precision = 10, scale = 5)
    private BigDecimal interestPerDay;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="DUE_DATE")
    private Date dueDate;

    @Column(name="PENALTY_PER_DAY", precision = 10, scale = 5)
    private BigDecimal penaltyPerDay;
}
