package jdc.spring.accountwebservice.service;

import jdc.spring.accountwebservice.converter.AccountConverter;
import jdc.spring.accountwebservice.dto.AccountDto;
import jdc.spring.accountwebservice.model.Account;
import jdc.spring.accountwebservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {

    @Autowired
    AccountConverter converter;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto[] getAccounts() {
        Account[] accounts = accountRepository.getAccounts();

        return converter.entitiesToDtos(accounts);
    }
}
