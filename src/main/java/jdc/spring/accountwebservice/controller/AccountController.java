package jdc.spring.accountwebservice.controller;

import jdc.spring.accountwebservice.exception.ResourceNotFoundException;
import jdc.spring.accountwebservice.model.Account;
import jdc.spring.accountwebservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId)
        throws ResourceNotFoundException {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id : " + accountId));
        return ResponseEntity.ok().body(account);
    }


}
