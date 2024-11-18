package org.example.ebankify.dto.transaction.request;


import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.enums.TransactionStatus;
import org.example.ebankify.enums.TransactionType;

@Getter
@Setter
public class TransactionCreateDto {

    private TransactionType type;

    @Min(1)
    private Double amount;

    private long receiverId;

    boolean  sameBank;
}
