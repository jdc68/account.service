package jdc.spring.accountwebservice.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDateTime;

@Schema(description = "Account Entity")
@Entity
@Table(name = "accounts")
@SecondaryTable(name="currencies", pkJoinColumns = @PrimaryKeyJoinColumn(name="curr_id"))
@NamedStoredProcedureQuery(name = "getAllAccounts",
        procedureName = "GET_ACCOUNTS")
public class Account {
    @Schema(description = "Account ID", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Schema(description = "Account numeric name", example = "0001")
    private String name;

    @Column(name = "balance", nullable = false)
    @Schema(description = "Remaining balance for current account")
    private Float balance;

    @Column(name = "currency_id", nullable = false)
    @Schema(description = "Account currency ID: 1 - USD; 2 - EUR; 3 - MDL")
    private int currency_id;

    @Column(name = "currency", table="currencies", nullable = false)
    @Schema(description = "Account currency")
    private String currency;

    @Column(name = "transaction_time", nullable = false)
    @Schema(description = "Date and time of the last transaction")
    private LocalDateTime transactionTime;

    public Account() {

    }

    public Account(int id, String name, Float balance, int currency_id, String currency, LocalDateTime transactionTime) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency_id = currency_id;
        this.currency = currency;
        this.transactionTime = transactionTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public int getCurrencyId() {
        return currency_id;
    }

    public void setCurrencyId(int currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
