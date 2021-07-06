package jdc.spring.accountwebservice.converter;

import jdc.spring.accountwebservice.dto.AccountDto;
import jdc.spring.accountwebservice.model.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AccountConverter {

    public AccountDto entityToDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setName(account.getName());
        dto.setBalance(account.getBalance());
        dto.setCurrency(account.getCurrency());
        dto.setTransactionTime(account.getTransactionTime());

        return dto;
    }

    public AccountDto[] entitiesToDtos(Account[] accounts) {

        return Arrays.stream(accounts)
                .map(this::entityToDto)
                .toArray(AccountDto[]::new);
    }

    public Account dtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());
        account.setCurrency(dto.getCurrency());
        account.setTransactionTime(dto.getTransactionTime());

        return account;
    }

    public Account[] dtosToEntities(AccountDto[] dto) {

        return Arrays.stream(dto)
                .map(this::dtoToEntity)
                .toArray(Account[]::new);
    }

}
