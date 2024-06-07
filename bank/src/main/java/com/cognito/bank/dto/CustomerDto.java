package com.cognito.bank.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record CustomerDto(
        String id,
        String name,
        String surname,
        Set<CustomerAccountDto> accounts
) {
}
