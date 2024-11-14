package org.example.ebankify.controller;

import org.example.ebankify.entity.Loan;
import org.example.ebankify.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{id}")
    public Loan getLoanId(@PathVariable Long id) {
        return loanService.getLoan(id);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {

        return loanService.saveLoan(loan);
    }

    @PostMapping
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoan(loan);
    }

}
