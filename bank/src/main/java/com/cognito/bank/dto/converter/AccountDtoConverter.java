package com.cognito.bank.dto.converter;

import com.cognito.bank.dto.AccountCustomerDto;
import com.cognito.bank.dto.AccountDto;
import com.cognito.bank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class AccountDtoConverter {
    private final TransactionDtoConverter transactionDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;

    public AccountDto convert(Account account) {
        return new AccountDto(
                account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::convertToTransactionDto)
                        .collect(Collectors.toSet()),
                customerDtoConverter.convertToAccountCustomerDto(Optional.ofNullable(account.getCustomer()))
        );
    }
}
