package jdc.spring.accountwebservice.service;

import jdc.spring.accountwebservice.dto.AccountDto;
import jdc.spring.accountwebservice.model.Account;

public interface AccountService {

    AccountDto[] getAccounts();
}
