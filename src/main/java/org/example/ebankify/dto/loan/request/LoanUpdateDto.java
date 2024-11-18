package org.example.ebankify.dto.loan.request;

import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.dto.user.respense.UserDtoResponse;
import org.example.ebankify.enums.LoanStatus;

@Getter
@Setter
public class LoanUpdateDto {

    private Long id;

    private Double principal;

    private Double interestRate;

    private int termMonths;

    private LoanStatus status;

    private Long userId;

}
