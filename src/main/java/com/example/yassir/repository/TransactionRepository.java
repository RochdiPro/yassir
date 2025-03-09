package com.example.yassir.repository;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
     List<Transaction> findBySourceAccountOrDestinationAccount(BankAccount source, BankAccount destination);
}