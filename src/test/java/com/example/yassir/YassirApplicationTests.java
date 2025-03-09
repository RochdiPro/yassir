package com.example.yassir;

import com.example.yassir.model.BankAccount;
import com.example.yassir.model.Customer;
import com.example.yassir.repository.BankAccountRepository;
import com.example.yassir.repository.CustomerRepository;
import com.example.yassir.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class YassirApplicationTests {

    @Test
    void contextLoads() {
    }

}
