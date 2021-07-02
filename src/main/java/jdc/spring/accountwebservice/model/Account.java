package jdc.spring.accountwebservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "accounts")
@NamedStoredProcedureQuery(name = "getAllAccounts",
        procedureName = "GET_ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Float balance;
    private Currency currency;
    private LocalDateTime transactionTime;

    public Account() {

    }

    public Account(Long id, String name, Float balance, Currency currency, LocalDateTime transactionTime) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.transactionTime = transactionTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "accountName", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "balance", nullable = false)
    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Column(name = "currencyId", nullable = false)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Column(name = "time", nullable = false)
    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }


}
