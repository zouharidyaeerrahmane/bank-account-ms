package com.zouhari.bankaccount.web;


import com.zouhari.bankaccount.dto.BankAccountRequestDTO;
import com.zouhari.bankaccount.dto.BankAccountResponseDTO;
import com.zouhari.bankaccount.entities.BankAccount;
import com.zouhari.bankaccount.entities.Customer;
import com.zouhari.bankaccount.repositories.BankAccountRepository;
import com.zouhari.bankaccount.repositories.CustomerRepository;
import com.zouhari.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;


    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById( id).orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }


    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

}