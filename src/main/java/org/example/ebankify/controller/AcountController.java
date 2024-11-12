package org.example.ebankify.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.ebankify.entity.Account;
import org.example.ebankify.service.account.AccountService;
import org.example.ebankify.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/account")
public class AcountController {

    private final AccountService accountService;
    private final Jwt jwt;

    @Autowired
    public AcountController(AccountService accountService, Jwt jwt) {
        this.accountService = accountService;
        this.jwt = jwt;
    }

    @GetMapping
    public List<Account> authUserAccount(HttpServletRequest request) {
        String email = jwt.extractInputString(request.getHeader("Authorization").substring(7));

        email = email;

        return null;
    }

}