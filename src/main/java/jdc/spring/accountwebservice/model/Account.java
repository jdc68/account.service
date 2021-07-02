package jdc.spring.accountwebservice.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDateTime;

@Schema(description = "Account Entity")
@Entity
@Table(name = "accounts")
@NamedStoredProcedureQuery(name = "getAllAccounts",
        procedureName = "GET_ACCOUNTS")
public class Account {
    @Schema(description = "Account ID", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Account numeric name", example = "0001")
    private String name;

    @Schema(description = "Remaining balance for current account")
    private Float balance;

    @Schema(description = "Account currency: 1 - USD; 2 - EUR; 3 - MDL")
    private int currency;

    @Schema(description = "Date and time of the last transaction")
    private LocalDateTime transactionTime;

    public Account() {

    }

    public Account(Long id, String name, Float balance, int currency, LocalDateTime transactionTime) {
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
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
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
