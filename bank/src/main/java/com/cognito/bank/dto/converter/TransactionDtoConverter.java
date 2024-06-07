package com.cognito.bank.dto.converter;

import com.cognito.bank.dto.TransactionDto;
import com.cognito.bank.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convertToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getCreationDate()
        );
    }
}
