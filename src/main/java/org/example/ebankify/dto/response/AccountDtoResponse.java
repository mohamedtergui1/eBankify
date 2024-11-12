package org.example.ebankify.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ebankify.enums.AccountStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDtoResponse {

    private Long id;

    private Double balance;

    private String accountNumber;

    private AccountStatus status;

}