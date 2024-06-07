package com.cognito.bank.dto;

import com.cognito.bank.model.Transaction;
import com.cognito.bank.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public record TransactionDto(
        String id,
        BigDecimal amount,
        TransactionType transactionType,
        LocalDateTime creationDate
)  {
}
