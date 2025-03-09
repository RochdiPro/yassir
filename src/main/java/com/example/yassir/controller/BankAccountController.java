package com.example.yassir.controller;

import com.example.yassir.model.BankAccount;
import com.example.yassir.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Bank Account Management", description = "Endpoints for managing bank accounts")
public class BankAccountController {
    private final BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @Operation(summary = "Create a new bank account", description = "Creates a bank account with an initial balance.")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        return ResponseEntity.ok(accountService.createAccount(account.getCustomer().getId(), account.getBalance()));
    }

    @GetMapping("/{accountId}")
    @Operation(summary = "Get bank account by ID", description = "Retrieves a bank account using its unique ID.")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }

    @GetMapping("/{accountId}/balance")
    @Operation(summary = "Get account balance", description = "Fetches the balance of a specified bank account.")
    public ResponseEntity<Double> getBalance(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccountBalance(accountId));
    }

    @PutMapping("/{accountId}")
    @Operation(summary = "Update account balance", description = "Updates the balance of an existing bank account.")
    public ResponseEntity<BankAccount> updateBalance(@PathVariable Long accountId, @RequestBody BankAccount account) {
        return ResponseEntity.ok(accountService.updateAccountBalance(accountId, account.getBalance()));
    }

    @DeleteMapping("/{accountId}")
    @Operation(summary = "Delete an account", description = "Deletes a bank account using its ID.")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Deleted");
    }
}
