package com.example.yassir.service;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Transaction;
import com.example.yassir.repository.BankAccountRepository;
import com.example.yassir.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    private final BankAccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    public TransactionService(BankAccountRepository accountRepo, TransactionRepository transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public void transferMoney(Long sourceId, Long destId, Double amount) {
        BankAccount source = accountRepo.findById(sourceId)
                .orElseThrow(() -> new RuntimeException("Source account not found"));
        BankAccount destination = accountRepo.findById(destId)
                .orElseThrow(() -> new RuntimeException("destination account not found"));

        if (source.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        accountRepo.save(source);
        accountRepo.save(destination);

        transactionRepo.save(new Transaction(null, amount, LocalDate.now(), source, destination));
    }

    public List<Transaction> getTransactionHistory(Long accountId) {
        BankAccount account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("account not found"));

        return transactionRepo.findBySourceAccountOrDestinationAccount(account, account);
    }
}

