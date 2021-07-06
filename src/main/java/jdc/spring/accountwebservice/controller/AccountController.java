package jdc.spring.accountwebservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdc.spring.accountwebservice.model.Account;
import jdc.spring.accountwebservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Accounts", description = "Account access")
@Slf4j
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Operation(
            summary = "Fetch Accounts",
            description = "Returns the list of all existing accounts"
    )
    @GetMapping("/accounts")
    public ResponseEntity<Account[]> getAllAccounts() {
        try {
            return ResponseEntity.ok(accountRepository.getAccounts());
        } catch(DataAccessException e) {
            String msg = "Unable to access data.";
            logger.error(msg);
            throw e;
        }
    }
//    public Account[] getAllAccounts() {
//        return accountRepository.getAccounts();
//    }
}