package jdc.spring.accountwebservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdc.spring.accountwebservice.converter.AccountConverter;
import jdc.spring.accountwebservice.dto.AccountDto;
import jdc.spring.accountwebservice.repository.AccountRepository;
import jdc.spring.accountwebservice.service.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Accounts", description = "Account access")
@Slf4j
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    AccountConverter converter;

    @Autowired
    AccountServiceImpl accountService;

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Operation(
            summary = "Fetch Accounts",
            description = "Returns the list of all existing accounts"
    )
    @GetMapping("/accounts")
    public ResponseEntity<AccountDto[]> getAllAccounts() {
        try {
//            Account[] accounts = accountRepository.getAccounts();
//
//            return ResponseEntity.ok(converter.entitiesToDtos(accounts));
            return ResponseEntity.ok(accountService.getAccounts());
        } catch(DataAccessException e) {
            String msg = "Unable to access data.";
            logger.error(msg, e);
            return ResponseEntity.status(500).build();
        }
    }
}