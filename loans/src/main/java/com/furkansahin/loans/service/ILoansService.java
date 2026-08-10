package com.furkansahin.loans.service;

import com.furkansahin.loans.dto.LoansDto;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    Boolean updateLoan(LoansDto loansDto);

    Boolean deleteLoan(String mobileNumber);
}
