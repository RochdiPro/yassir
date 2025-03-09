package com.example.yassir;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Customer;
import com.example.yassir.repository.BankAccountRepository;
import com.example.yassir.repository.CustomerRepository;
import com.example.yassir.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankAccountServiceTest {

    @Mock private BankAccountRepository accountRepo;
    @Mock private CustomerRepository customerRepo;
    @InjectMocks private BankAccountService bankAccountService;

    public BankAccountServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccount() {
        Customer customer = new Customer(1L, "Rochdi", null);
        when(customerRepo.findById(1L)).thenReturn(Optional.of(customer));

        BankAccount account = new BankAccount(1L, 100.0, customer);
        when(accountRepo.save(any(BankAccount.class))).thenReturn(account);

        BankAccount created = bankAccountService.createAccount(1L, 100.0);
        assertNotNull(created);
        assertEquals(100.0, created.getBalance());
    }
}

