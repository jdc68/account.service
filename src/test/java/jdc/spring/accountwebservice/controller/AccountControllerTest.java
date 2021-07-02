package jdc.spring.accountwebservice.controller;

import jdc.spring.accountwebservice.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountControllerTest {

    Account accounts;

    @Before
    public void setUp() {
        accounts = new Account();
    }


    @Test
    public void getAllAccounts() {
        Long idValue = 2L;

        accounts.setId(idValue);

        assertEquals(idValue, accounts.getId());
    }

    @Test
    public void testGetAllAccounts() {
    }
}