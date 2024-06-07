package com.cognito.bank.controller;

import com.cognito.bank.dto.AccountDto;
import com.cognito.bank.dto.CreateAccountRequest;
import com.cognito.bank.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(
            @Valid @RequestBody CreateAccountRequest request
    ) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
