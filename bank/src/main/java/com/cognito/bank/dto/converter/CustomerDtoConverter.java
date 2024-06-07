package com.cognito.bank.dto.converter;

import com.cognito.bank.dto.AccountCustomerDto;
import com.cognito.bank.dto.CustomerAccountDto;
import com.cognito.bank.dto.CustomerDto;
import com.cognito.bank.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerDtoConverter {
    private final CustomerAccountDtoConverter converter;

    public CustomerDto convertToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts().stream()
                        .map(converter::convertToCustomerAccountDto)
                        .collect(Collectors.toSet())
        );
    }

    public AccountCustomerDto convertToAccountCustomerDto(Optional<Customer> customer) {
        return customer.map(f->new AccountCustomerDto(f.getId(), f.getName(), f.getSurname()))
                .orElse(null);
    }
}
