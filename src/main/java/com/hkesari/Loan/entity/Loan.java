package com.hkesari.Loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="LOANS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name="PAYMENT_DATE")
    private Date paymentDate;
    @Column(name="INTEREST_PER_DAY")
    private String interestPerDay;
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name="DUE_DATE")
    private Date dueDate;
    @Column(name="PENALTY_PER_DAY")
    private String penaltyPerDay;

}
