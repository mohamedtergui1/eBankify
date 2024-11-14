package org.example.ebankify.service.transaction;

import org.example.ebankify.entity.Transaction;

public interface TransactionService {

    Transaction getTransaction(Long id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);

    Transaction updateTransaction(Transaction transaction);

}
