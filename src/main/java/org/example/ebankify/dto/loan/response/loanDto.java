package org.example.ebankify.dto.loan.response;

import org.example.ebankify.dto.user.respense.UserDtoResponse;
import org.example.ebankify.enums.LoanStatus;

public class loanDto {

    private Long id;


    private Double principal;

    private Double interestRate;

    private int termMonths;


    private LoanStatus status;

    private UserDtoResponse user;
}
