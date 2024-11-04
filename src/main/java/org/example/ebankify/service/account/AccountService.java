package org.example.ebankify.service.account;

import org.example.ebankify.entity.Account;

public interface AccountService {
    Account getAccount(long id);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(long id);
}
