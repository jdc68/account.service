package jdc.spring.accountwebservice.repository;

import jdc.spring.accountwebservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Procedure("GET_ACCOUNTS")
    List<Object> getAccounts();
}