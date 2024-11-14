package org.example.ebankify.service.transaction;

import org.example.ebankify.entity.Account;
import org.example.ebankify.entity.Transaction;
import org.example.ebankify.exception.BadRequest;
import org.example.ebankify.exception.NotFoundException;
import org.example.ebankify.repository.AccountRepository;
import org.example.ebankify.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction getTransaction(Long id) {

        return transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found"));

    }

    @Override
    @Transactional
    public Transaction saveTransaction(Transaction transaction) {

        Account sender = accountRepository.findByAccountNumber(transaction.getSender().getAccountNumber()).orElseThrow(() -> new NotFoundException("Account sender not found"));
        Account receiver = accountRepository.findByAccountNumber(transaction.getReceiver().getAccountNumber()).orElseThrow(() -> new NotFoundException("Account receiver not found"));

        if (sender.getBalance() < transaction.getAmount()) {
            throw new BadRequest("tha balance is not enough");
        }

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        receiver.setBalance(receiver.getBalance() + transaction.getAmount());
        accountRepository.save(sender);
        accountRepository.save(receiver);
        return transactionRepository.save(transaction);

    }

}
