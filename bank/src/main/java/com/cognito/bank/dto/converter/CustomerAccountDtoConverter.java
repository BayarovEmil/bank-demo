package com.cognito.bank.dto.converter;

import com.cognito.bank.dto.CustomerAccountDto;
import com.cognito.bank.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerAccountDtoConverter {
    private final TransactionDtoConverter converter;

    public CustomerAccountDto convertToCustomerAccountDto(Account account) {
        return new CustomerAccountDto(
                Objects.requireNonNull(account.getId()),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(converter::convertToTransactionDto)
                        .collect(Collectors.toSet())
        );
    }
}
