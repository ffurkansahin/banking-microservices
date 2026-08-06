package com.furkansahin.accounts.service;

import com.furkansahin.accounts.dto.CustomerDto;


public interface IAccountsService {

    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    Boolean updateAccount(CustomerDto customerDto);
    Boolean deleteAccount(String mobileNumber);
}
