package org.example.ebankify.dto.transaction.request;

import org.example.ebankify.enums.TransactionStatus;
import org.example.ebankify.enums.TransactionType;

public class TransactionUpdateDto {
    private Long id;

    private TransactionType type;

    private Double amount;

    private TransactionStatus status;

    private long receiverId;
}
