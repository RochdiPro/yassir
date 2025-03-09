package com.example.yassir;

import com.example.yassir.model.BankAccount;
import com.example.yassir.repository.BankAccountRepository;
import com.example.yassir.repository.TransactionRepository;
import com.example.yassir.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock private BankAccountRepository accountRepo;
    @Mock private TransactionRepository transactionRepo;
    @InjectMocks private TransactionService transactionService;

    public TransactionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransferMoney() {
        BankAccount acc1 = new BankAccount(1L, 500.0, null);
        BankAccount acc2 = new BankAccount(2L, 200.0, null);

        when(accountRepo.findById(1L)).thenReturn(Optional.of(acc1));
        when(accountRepo.findById(2L)).thenReturn(Optional.of(acc2));

        transactionService.transferMoney(1L, 2L, 100.0);

        assertEquals(400.0, acc1.getBalance());
        assertEquals(300.0, acc2.getBalance());
    }
}
