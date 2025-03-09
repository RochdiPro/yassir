package com.example.yassir.controller;

import com.example.yassir.model.Transaction;
import com.example.yassir.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    @Operation(summary = "Transfer money", description = "Transfers money from one account to another.")
    public ResponseEntity<String> transferMoney(@RequestBody Transaction transaction) {
        transactionService.transferMoney(
                transaction.getSourceAccount().getId(),
                transaction.getDestinationAccount().getId(),
                transaction.getAmount()
        );
        return ResponseEntity.ok("Transfer successful!");
    }

    @GetMapping("/{accountId}/history")
    @Operation(summary = "Get transaction history", description = "Retrieves the transaction history for a specific account.")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactionHistory(accountId));
    }

}
