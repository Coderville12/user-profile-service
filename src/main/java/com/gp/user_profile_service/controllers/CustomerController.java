package com.gp.user_profile_service.controllers;

import com.gp.user_profile_service.dto.CustomerDto;
import com.gp.user_profile_service.entity.Customer;
import com.gp.user_profile_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController
{

    private final CustomerService customerService;


    @PostMapping()
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = dtoToEntity(customerDto);
        Customer savedCustomer = customerService.saveCustomer(customer);
        return entityToDto(savedCustomer);
    }
    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return entityToDto(customer);
    }


    public Customer dtoToEntity(com.gp.user_profile_service.dto.CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobile(customerDto.getMobile())
                .status(customerDto.getStatus())
                .password(customerDto.getPassword())
                .build();
    }

    public CustomerDto entityToDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .status(customer.getStatus())
                .build();
    }
}
