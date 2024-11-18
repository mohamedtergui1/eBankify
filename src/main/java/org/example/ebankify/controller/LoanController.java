package org.example.ebankify.controller;

import lombok.RequiredArgsConstructor;
import org.example.ebankify.entity.Loan;
import org.example.ebankify.service.loan.LoanService;
import org.example.ebankify.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;


    @GetMapping("/{id}")
    public Loan getLoanId(@PathVariable Long id) {
        return loanService.getLoan(id);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }

    @PutMapping
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoan(loan);
    }


}
