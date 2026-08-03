package com.furkansahin.accounts.dto;

import lombok.Data;

@Data
public class AccountsDto {
    private Long accountNumber;
    
    private String accountType;

    private String branchAddress;
}
