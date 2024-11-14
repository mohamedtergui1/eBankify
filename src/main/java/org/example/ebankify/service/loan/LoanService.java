package org.example.ebankify.service.loan;

import org.example.ebankify.entity.Loan;

public interface LoanService {

    Loan getLoan(Long id);

    Loan saveLoan(Loan loan);

    void deleteLoan(int id);

    Loan updateLoan(Loan loan);

}
