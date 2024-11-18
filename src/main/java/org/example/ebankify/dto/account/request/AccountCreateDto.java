package org.example.ebankify.dto.account.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.example.ebankify.enums.AccountStatus;

@Getter
public class AccountCreateDto {

    @NotNull
    private Double balance;

    @NotNull
    @Size(max = 24 )
    private String accountNumber;

    @NotNull
    private AccountStatus status;

}
