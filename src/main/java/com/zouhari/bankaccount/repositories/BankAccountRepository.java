package com.zouhari.bankaccount.repositories;

import com.zouhari.bankaccount.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/

import java.util.List;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
