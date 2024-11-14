package org.example.ebankify.dto.transaction.request;


import lombok.Getter;
import org.example.ebankify.enums.TransactionStatus;
import org.example.ebankify.enums.TransactionType;

@Getter
public class TransactionCreateDto {


    private TransactionType type;

    private Double amount;

    private TransactionStatus status;

    private long receiverId;

}
