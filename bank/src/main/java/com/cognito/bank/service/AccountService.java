package com.cognito.bank.service;

import com.cognito.bank.dto.AccountDto;
import com.cognito.bank.dto.CreateAccountRequest;
import com.cognito.bank.dto.converter.AccountDtoConverter;
import com.cognito.bank.model.Account;
import com.cognito.bank.model.Customer;
import com.cognito.bank.model.Transaction;
import com.cognito.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final CustomerService customerService;
    private final Clock clock;
    private final AccountRepository accountRepository;
    private final AccountDtoConverter converter;

    public AccountDto createAccount(CreateAccountRequest request) {
        Customer customer =  customerService.findCustomerById(request.id());

        Account account = new Account(
                customer,
                request.initialCredit(),
                getLocalDateTimeNow()
        );
        if (request.initialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    request.initialCredit(),
                    getLocalDateTimeNow(),
                    account
            );

            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}
