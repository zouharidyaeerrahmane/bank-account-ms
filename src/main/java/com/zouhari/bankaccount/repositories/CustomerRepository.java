package com.zouhari.bankaccount.repositories;


import com.zouhari.bankaccount.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
