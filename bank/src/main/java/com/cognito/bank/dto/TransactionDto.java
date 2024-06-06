package com.cognito.bank.dto;

import com.cognito.bank.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(
        String id,
        BigDecimal amount,
        TransactionType transactionType,
        LocalDateTime creationDate
) {
}
