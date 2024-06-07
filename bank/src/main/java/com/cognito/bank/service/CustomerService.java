package com.cognito.bank.service;

import com.cognito.bank.dto.CustomerDto;
import com.cognito.bank.dto.converter.CustomerDtoConverter;
import com.cognito.bank.exception.CustomerNotFoundException;
import com.cognito.bank.model.Customer;
import com.cognito.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer not founded by id:: "+id));
    }

    public CustomerDto getCustomerById(String id) {
        return converter.convertToCustomerDto(findCustomerById(id));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
