package org.example.ebankify.controller;


import org.example.ebankify.dto.account.request.AccountUpdateDto;
import org.example.ebankify.dto.account.response.AccountDtoResponse;
import org.example.ebankify.entity.Account;
import org.example.ebankify.mappers.AccountMapper;
import org.example.ebankify.service.account.AccountService;
import org.example.ebankify.service.user.UserService;
import org.example.ebankify.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users/account")
public class AcountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final Jwt jwt;
    private final UserService userService;

    @Autowired
    public AcountController(AccountService accountService, Jwt jwt, AccountMapper accountMapper, UserService userService) {
        this.accountService = accountService;
        this.jwt = jwt;
        this.accountMapper = accountMapper;
        this.userService = userService;
    }

    @GetMapping
    public Page<Account> authUserAccounts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestHeader("Authorization") String token) {

        String email = jwt.extractInputString(token.substring(7));
        return accountService.getAuthUserAccounts(email.split("<@>")[0], page, size);
    }

    @PostMapping
    public Account createAccount(@RequestBody AccountDtoResponse accountDtoResponse, @RequestHeader("Authorization") String token) {
        Account account = accountMapper.toEntity(accountDtoResponse);
        account.setUser(userService.getUserByEmail(jwt.extractInputString(token.substring(7).split("<@>")[0])));
        return accountService.createAccount(account);
    }

    @PutMapping
    public Account updateAccount(@RequestBody AccountUpdateDto accountUpdateDto) {
        return accountService.updateAccount(accountMapper.toEntity(accountUpdateDto));
    }

}