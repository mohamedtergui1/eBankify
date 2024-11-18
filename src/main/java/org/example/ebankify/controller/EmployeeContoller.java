package org.example.ebankify.controller;

import lombok.RequiredArgsConstructor;
import org.example.ebankify.dto.account.request.AccountUpdateDto;
import org.example.ebankify.dto.account.response.AccountDtoResponse;
import org.example.ebankify.dto.loan.request.LoanUpdateDto;
import org.example.ebankify.dto.loan.response.loanDto;
import org.example.ebankify.entity.Account;
import org.example.ebankify.entity.Loan;
import org.example.ebankify.mappers.AccountMapper;
import org.example.ebankify.mappers.LoanMapper;
import org.example.ebankify.service.account.AccountService;
import org.example.ebankify.service.loan.LoanService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeContoller {

    private final LoanService loanService;
    private final LoanMapper loanMapper;
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PutMapping("/loan")
    public loanDto updateLoan(@RequestBody LoanUpdateDto loanUpdateDto) {
        return  loanMapper.toDto(loanService.updateLoan(loanMapper.toEntity(loanUpdateDto)));
    }

    @PutMapping("/account")
    public AccountDtoResponse updateAccount(@RequestBody AccountUpdateDto accountUpdateDto) {
        return accountMapper.toDto(accountService.updateAccount(accountMapper.toEntity(accountUpdateDto)));
    }
}
