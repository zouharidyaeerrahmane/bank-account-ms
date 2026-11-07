package com.zouhari.bankaccount.entities;


import com.zouhari.bankaccount.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}

