package org.example.ebankify.service.transaction;

import org.example.ebankify.entity.Transaction;
import org.example.ebankify.exception.DeleteUpdateException;
import org.example.ebankify.exception.NotFoundException;
import org.example.ebankify.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getTransaction(Long id) {

        return transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found"));

    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new DeleteUpdateException("Transaction not deleted cause isn't found"));
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        if (transactionRepository.existsById(transaction.getId())) {
            return transactionRepository.save(transaction);
        }
        throw new DeleteUpdateException("Transaction not deleted cause isn't found");
    }
}
