package org.example.ebankify.service.loan;

import org.example.ebankify.entity.Loan;
import org.example.ebankify.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan getLoan(Long id) {
        return null;
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return null;
    }

    @Override
    public void deleteLoan(int id) {

    }

    @Override
    public Loan updateLoan(Loan loan) {
        return null;
    }
}
