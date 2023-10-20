package com.hkesari.Loan.service.scheduledService;

import com.hkesari.Loan.model.Loan;
import com.hkesari.Loan.service.LoanService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ExpiredLoans {
    private final LoanService loanService;
    public ExpiredLoans(LoanService loanService){
        this.loanService = loanService;
    }

    @PostConstruct
    @Scheduled(cron = "${daily.schedule}")
    public void runDailyTask() throws Exception {
        try{
            List<Loan> defaulters = loanService.getDefaulters();
            log.info("Defaulter check executed at "+ LocalDateTime.now().toString());
            if(!defaulters.isEmpty()) {
                log.warn("These are the defaulter loans : [{}]", defaulters.toString());
            }
        }
        catch(Exception e){
            log.error("Error occurred while running the defaulter check ");
            throw e;
        }
    }
}
