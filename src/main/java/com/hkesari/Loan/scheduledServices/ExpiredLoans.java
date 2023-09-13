package com.hkesari.Loan.scheduledServices;

import com.hkesari.Loan.models.Loan;
import com.hkesari.Loan.services.LoanService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpiredLoans {

    @Autowired
    private LoanService loanService;

    private static final Logger log = LoggerFactory.getLogger(ExpiredLoans.class);

    @PostConstruct
    @Scheduled(cron = "${daily.schedule}")
    public void runDailyTask() {
        List<Loan> defaulters = loanService.getDefaulters();
        log.info("Daily check executed at "+ LocalDateTime.now().toString());
        if(!defaulters.isEmpty()) {
            log.warn("\nThese are the defaulter loans : ");
            for(Loan loan: defaulters)
                System.out.println(loan.getLoanId());
        }
    }
}
