package org.example.ebankify.dto.loan.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.entity.User;
import org.example.ebankify.enums.LoanStatus;
@Getter
@Setter
public class LoanCreateDto {

    @Min(1)
    private Double principal;

    @Min(1)
    private Double interestRate;

    @Min(1)
    private int termMonths;

}
