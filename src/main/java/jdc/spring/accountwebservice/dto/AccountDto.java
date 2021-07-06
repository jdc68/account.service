package jdc.spring.accountwebservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDto {

    private int id;
    private String name;
    private Float balance;
    private String currency;
    private LocalDateTime transactionTime;
}
