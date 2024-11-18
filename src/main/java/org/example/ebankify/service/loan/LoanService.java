package org.example.ebankify.service.loan;

import org.example.ebankify.entity.Loan;

public interface LoanService {

    Loan getLoan(Long id);

    Loan saveLoan(Loan loan);

    Loan updateLoan(Loan loan);

    void processLoanPayments();
}
