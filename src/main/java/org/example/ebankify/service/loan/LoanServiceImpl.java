package org.example.ebankify.service.loan;

import lombok.RequiredArgsConstructor;
import org.example.ebankify.entity.Account;
import org.example.ebankify.entity.Loan;
import org.example.ebankify.enums.LoanStatus;
import org.example.ebankify.exception.NotAuthException;
import org.example.ebankify.exception.NotFoundException;
import org.example.ebankify.repository.AccountRepository;
import org.example.ebankify.repository.LoanRepository;
import org.example.ebankify.repository.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public Loan getLoan(Long id) {
        return loanRepository.findById(id).orElseThrow(()-> new NotFoundException("loan not found"));
    }

    @Override
    public Loan saveLoan(Loan loan) {

        return loanRepository.save(loan);
    }


    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void processLoanPayments() {
            List<Loan> loans = loanRepository.findAllByStatus(LoanStatus.APPROVED);
            for (Loan loan : loans) {
                Optional<Account> Optaccount = accountRepository.findByUserId(loan.getUser().getId());
                if(Optaccount.isPresent()) {
                    Account account = Optaccount.get();
                    account.setBalance(account.getBalance()- loan.calculateMonthlyPayment());
                    accountRepository.save(account);
                }
            }
    }


}
