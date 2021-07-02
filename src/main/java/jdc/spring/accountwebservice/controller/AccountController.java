package jdc.spring.accountwebservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdc.spring.accountwebservice.model.Account;
import jdc.spring.accountwebservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Accounts", description = "Account access")
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Operation(
            summary = "Fetch Accounts",
            description = "Returns the list of all existing accounts"
    )
    @GetMapping("/accounts")
    public Account[] getAllAccounts() {
        return accountRepository.getAccounts();
    }
}