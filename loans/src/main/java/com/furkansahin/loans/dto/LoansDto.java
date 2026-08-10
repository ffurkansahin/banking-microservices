package com.furkansahin.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoansDto {

    @NotEmpty(message = "Mobile Number can not be empty or null")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "Loan Type can not be a null or empty")
    private String loanType;

    @Positive(message = "Total loan amount must be greater than zero")
    private Integer totalLoan;

    @PositiveOrZero(message = "Total loan amount paid must be equal or greater than zero")
    private Integer amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private Integer outstandingAmount;
}
