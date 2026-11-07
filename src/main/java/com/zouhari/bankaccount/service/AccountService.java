package com.zouhari.bankaccount.service;


import com.zouhari.bankaccount.dto.BankAccountRequestDTO;
import com.zouhari.bankaccount.dto.BankAccountResponseDTO;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}