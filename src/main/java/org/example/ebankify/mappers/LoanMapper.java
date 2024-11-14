package org.example.ebankify.mappers;

import org.example.ebankify.dto.loan.request.LoanCreateDto;
import org.example.ebankify.dto.loan.request.LoanUpdateDto;
import org.example.ebankify.dto.loan.response.loanDto;
import org.example.ebankify.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan toEntity(LoanCreateDto loanCreateDto);

    Loan toEntity(LoanUpdateDto loanUpdateDto);

    loanDto toDto(Loan loan);

}
