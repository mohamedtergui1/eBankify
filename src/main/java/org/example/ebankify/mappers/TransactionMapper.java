package org.example.ebankify.mappers;

import org.example.ebankify.dto.transaction.request.TransactionCreateDto;
import org.example.ebankify.dto.transaction.response.TransactionResponseDto;
import org.example.ebankify.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toEntity(TransactionCreateDto transactionCreateDto);

    TransactionResponseDto toResponseDto(Transaction transaction);

}
