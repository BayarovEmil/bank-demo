package com.cognito.bank.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank(message = "Customer id must not be empty")
        String id,
        @Min(value = 0,message = "Initial credit value must not be negative value")
        BigDecimal initialCredit
) {
}
