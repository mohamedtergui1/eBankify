package org.example.ebankify.dto.transaction.response;


import lombok.Getter;
import org.example.ebankify.dto.account.response.AccountDtoResponse;
import org.example.ebankify.enums.TransactionStatus;
import org.example.ebankify.enums.TransactionType;

@Getter
public class TransactionResponseDto {

    private Long id;

    private TransactionType type;

    private Double amount;

    private TransactionStatus status;

    private AccountDtoResponse sender;

    private AccountDtoResponse receiver;

}
