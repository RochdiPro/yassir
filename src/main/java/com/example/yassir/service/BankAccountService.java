package com.example.yassir.service;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Customer;
import com.example.yassir.repository.BankAccountRepository;
import com.example.yassir.repository.CustomerRepository;
import com.example.yassir.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final CustomerRepository customerRepo;
    private final BankAccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    public BankAccountService(CustomerRepository customerRepo, BankAccountRepository accountRepo, TransactionRepository transactionRepo) {
        this.customerRepo = customerRepo;
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public BankAccount createAccount(Long customerId, Double initialDeposit) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        BankAccount account = new BankAccount(null, initialDeposit, customer);
        return accountRepo.save(account);
    }

    public List<BankAccount> getAllAccounts() {
        return accountRepo.findAll();
    }

    public BankAccount getAccountById(Long accountId) {
        return accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    public Double getAccountBalance(Long accountId) {
        return getAccountById(accountId).getBalance();
    }

    public BankAccount updateAccountBalance(Long accountId, Double newBalance) {
        BankAccount account = getAccountById(accountId);
        account.setBalance(newBalance);
        return accountRepo.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepo.deleteById(accountId);
    }
}


