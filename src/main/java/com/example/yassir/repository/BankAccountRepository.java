package com.example.yassir.repository;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
     List<BankAccount> findByCustomer(Customer customer);
}