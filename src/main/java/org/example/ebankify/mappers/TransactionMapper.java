package org.example.ebankify.mappers;

import org.example.ebankify.dto.transaction.request.TransactionCreateDto;
import org.example.ebankify.dto.transaction.request.TransactionUpdateDto;
import org.example.ebankify.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toEntity(TransactionCreateDto transactionCreateDto);

    Transaction toEntity(TransactionUpdateDto transactionUpdateDto);

}
