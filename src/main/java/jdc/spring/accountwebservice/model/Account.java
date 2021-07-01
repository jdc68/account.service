package jdc.spring.accountwebservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Table(name = "Accounts")
public class Account {

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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
