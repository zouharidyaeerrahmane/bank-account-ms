package com.zouhari.bankaccount.mappers;


import com.zouhari.bankaccount.dto.BankAccountResponseDTO;
import com.zouhari.bankaccount.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}