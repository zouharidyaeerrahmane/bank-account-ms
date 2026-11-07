package com.zouhari.bankaccount.web;


import com.zouhari.bankaccount.dto.BankAccountRequestDTO;
import com.zouhari.bankaccount.dto.BankAccountResponseDTO;
import com.zouhari.bankaccount.entities.BankAccount;
import com.zouhari.bankaccount.mappers.AccountMapper;
import com.zouhari.bankaccount.repositories.BankAccountRepository;
import com.zouhari.bankaccount.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;

    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Bank account not found")));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount) {
        BankAccount account=bankAccountRepository.findById(id).orElse(null);
        if(bankAccount.getBalance() !=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt() !=null) account.setCreatedAt(new Date());
        if(bankAccount.getType() !=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency() !=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}